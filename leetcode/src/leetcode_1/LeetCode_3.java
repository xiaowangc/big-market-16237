package leetcode_1;

/** 无重复字符的最长子串 中等
 * @author wangyc
 * @date 2022/4/26
 */
public class LeetCode_3 {

    private static int one(String s) {
        int index = 0;
        int len = s.length();
        String[] res = new String[len];
        int j = 0;
        int maxLength = 0;
        for(int i = 0; i < len; i++) {
            String tmp = String.valueOf(s.charAt(i));

            for(index = i + 1; index < len; index++) {
                if(tmp.contains(String.valueOf(s.charAt(index)))) {

                    break;
                }
                tmp += s.charAt(index);
            }
            res[j] = tmp;
            j++;
            maxLength = Math.max(maxLength, tmp.length());
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String[] s = new String[]{"bbbb","pwwkew"};
        for (String s1 : s) {
            System.out.println(one(s1));
        }
    }


}
