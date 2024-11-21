package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyc
 * @date 2023/2/22
 */
public class StringTest {

    public static List<String> getLabelNameFromContent(String content) {

        List<String> result = new ArrayList<>(16);
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '{' || content.charAt(i) == '｛') {
                i++;
                int startIndex = i;
                int endIndex = 0;
                while (i < content.length() && (content.charAt(i) == '{' || content.charAt(i) == '｛')) {
                    i++;
                    startIndex = i;
                }
                if (i == content.length()) {
                    break;
                }
                while (content.charAt(i) != '}' && content.charAt(i) != '｝') {
                    i++;
                    if (i == content.length()) {
                        endIndex = -1;
                        break;
                    }
                    endIndex = i;
                }
                if (endIndex == -1) {
                    continue;
                }
                String labelName = content.substring(startIndex, endIndex);
                result.add(labelName);
            }
        }
        return result;
    }

    public static List<String> getLabelNameFromContent2(String content) {
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c == '{') {
                addKey = true;
            } else if (c == '}') {
                if (!"".equals(key.toString())) {
                    result.add(key.toString());
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                }
            }
        }
        return result;
    }

    public static List<String> getLabelNameFromContent3(String content) {
        List<String> labelList = new ArrayList<>();
        // 存放模板标签
        StringBuilder msgLabel = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '{' || content.charAt(i) == '｛') {
                i++;
                while (i < content.length() && content.charAt(i) != '}' && content.charAt(i) != '｝') {
                    msgLabel.append(content.charAt(i++));
                }
                if (i == content.length()) {
                    return labelList;
                }
                String labelName = msgLabel.toString();
                msgLabel.setLength(0);
                labelList.add(labelName);
            }
        }
        return labelList;
    }

    public static void main(String[] args) {
        String content = "【健康160】{真实姓名}{医院简称}预约提示：您已成功预约{科室名称}{医生姓名}诊号。{温馨提醒：一、";
        String content2 = "{{{sa}";
        List<String> labelNameFromContent = StringTest.getLabelNameFromContent3(content);
        for (String s : labelNameFromContent) {
            System.out.println(s);
        }
    }
}
