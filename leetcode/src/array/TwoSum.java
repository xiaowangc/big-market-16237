package array;

/**
 * @author wangyc
 * @date 2023/2/16
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return one(nums, target);
    }

    // 先暴力破解
    private int[] one(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int val1 = nums[i];
            if (i == nums.length - 1) {
                return null;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (val1 == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] one = twoSum.one(nums, target);
        for (int i : one) {
            System.out.println(i);
        }
    }
}
