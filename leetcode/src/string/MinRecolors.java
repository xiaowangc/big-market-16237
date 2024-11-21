package string;

/**
 * @author wangyc
 * @date 2023/3/10
 */
public class MinRecolors {
    public static int minimumRecolors(String blocks, int k) {
        // 滑动窗口
        int left = 0;
        int right = 0;
        int len = blocks.length();
        int cw = 0;
        while(right < k) {
            cw += blocks.charAt(right) == 'W' ? 1 : 0;
            right++;
        }
        int res = cw;
        while(right < len) {
            cw += blocks.charAt(right) == 'W' ? 1 : 0;
            cw -= blocks.charAt(left) == 'W' ? 1 : 0;
            res = Math.min(res, cw);
            if(res == 0) {
                return 0;
            }
            left++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String blocks = "BBBBBBBWBW";
        int k = 7;
        int i = minimumRecolors(blocks, k);
        System.out.println(i);
    }
}
