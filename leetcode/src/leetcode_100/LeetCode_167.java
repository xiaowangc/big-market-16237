package leetcode_100;

/**
 * 两数之和 II - 输入有序数组 【中等】
 *
 * @author wangyc
 * @date 2022/4/23
 */
public class LeetCode_167 {

    // 双指针
    private static int[] one(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int num2 = target - numbers[left];
            if (num2 == numbers[right]) {
                return new int[]{left, right};
            } else if (num2 < numbers[right]) {
                right--;
                continue;
            }
            left++;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, 4, 5, 11, 15, 17};
        int target = 16;
        int[] one = one(nums, target);
        for (int i : one) {
            System.out.println(i);
        }
    }
}

