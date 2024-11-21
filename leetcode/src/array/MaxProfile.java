package array;

/**
 * @author wangyc
 * @date 2023/2/22
 */
public class MaxProfile {

    public static int maxProfile(int[] prices) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
            }
            max = Math.max(prices[right] - prices[left], max);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,2,5,1,3,3,4};
        System.out.println(maxProfile(prices));
    }
}
