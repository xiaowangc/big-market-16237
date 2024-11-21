package array;


/**
 * @author wangyc
 * @date 2023/2/16
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m  - 1;
        int left2 = m + n - 1;
        int right = n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right]) {
                int tmp = nums1[left2];
                nums1[left2] = nums1[left];
                nums1[left] = tmp;
                left2--;
                left--;
                continue;
            }
            nums1[left2] = nums2[right];
            right--;
            left2--;
        }
        if(left <= 0) {
            for(int i = 0; i <= right; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args)  {
        Merge merge = new Merge();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
