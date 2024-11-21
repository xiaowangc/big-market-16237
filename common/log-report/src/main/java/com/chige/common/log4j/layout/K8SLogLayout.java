package com.chige.common.log4j.layout;

import com.chige.common.log4j.kafka.KafkaMessage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.util.ReadOnlyStringMap;

import java.nio.charset.Charset;
import java.util.*;

@Plugin(name = "K8SLogLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class K8SLogLayout extends AbstractStringLayout {

    private final String type;
    private final String server;
    static  String pod_ip = System.getenv("POD_IP");

    protected K8SLogLayout(Charset charset, String type, String server) {
        super(charset);
        this.type = type;
        this.server = server;
    }

    /**
     * 插件的创建工厂
     */
    @PluginFactory
    public static K8SLogLayout createLayout(@PluginAttribute(value = "charset", defaultString = "UTF-8") final Charset charset,
                                            @PluginAttribute(value = "type", defaultString = "") final String type,
                                            @PluginAttribute(value = "server", defaultString = "") final String server) {
        return new K8SLogLayout(charset, type, server);
    }



    /**
     * 自定义日志输出格式
     * 该返回值就是我们所见到的日志输出格式，我们可以自定义为json、xml等等任意我们想要的格式
     */
    @Override
    public String toSerializable(LogEvent event) {
        Level level = event.getLevel();
        Message message = event.getMessage();
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setType(type);
        kafkaMessage.setTags(Collections.singletonList(server));
        kafkaMessage.setMessage(message.getFormattedMessage());
        kafkaMessage.setPath(event.getLoggerName());
        kafkaMessage.setHost(((pod_ip == null || pod_ip.length() < 2) ? "127.0.0.1" : pod_ip));
        kafkaMessage.setLevel(level.name());
        kafkaMessage.setFile(event.getLoggerName());
        ReadOnlyStringMap contextData = event.getContextData();
        kafkaMessage.setTraceId(contextData.<String>getValue("traceId"));
        kafkaMessage.setSpanId(contextData.<String>getValue("spanId"));
        return kafkaMessage.toString();
    }
}
