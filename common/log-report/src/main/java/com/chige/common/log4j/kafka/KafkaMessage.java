package com.chige.common.log4j.kafka;

import com.chige.common.log4j.BaseMessage;

import java.util.List;

/**
 * @author wangyc
 * @date 2023/4/14
 */
public class KafkaMessage extends BaseMessage {

    private String type;

    private List<String> tags;

    private String message;

    private String path;

    private String host;

    private String level;

    private String file;

    private String traceId;

    private String spanId;

    @Override
    public String toString() {
        return "{" +
                "\"type\":" + type  +
                ", \"tags\":" + tags +
                ", \"message\":" + message +
                ", \"path\":" + path +
                ", \"host\":" + host +
                ", \"level\":" + level +
                ", \"file\":" + file  +
                ", \"traceId\":" + traceId +
                ", \"spanId\":" + spanId +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }
}
