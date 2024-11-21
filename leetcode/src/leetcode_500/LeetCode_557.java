package leetcode_500;


/** 反转字符串中的单词 - III
 * 难度 - 简单
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例 1：
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 示例 2:
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 * @author wangyc
 * @date 2022/4/23
 */
public class LeetCode_557 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length() - 1);
        String[] words = s.split(" ");
        int start = 0, end = words.length - 1;
        while (start <= end) {
            String word = reverseWord(words[start]);
            String endWord = reverseWord(words[end]);
            words[start++] = word;
            words[end--] = endWord;
        }
        return String.join(" ", words);
    }

    private static String reverseWord(String word) {
        char[] chars = word.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Let's [take adaf LeetCode contest";
        System.out.println(s.replaceAll("\\[","【"));
    }
}
