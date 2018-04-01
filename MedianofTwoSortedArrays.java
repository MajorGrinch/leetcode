import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0.0;
        int len = nums1.length + nums2.length;
        int len1 = nums1.length, len2 = nums2.length;
        int[] nums = new int[len];
        int i = 0, j = 0;
        for(int k = 0; k < len; k++){
            if(i >= len1) nums[k] = nums2[j++];
            else if(j >= len2) nums[k] = nums1[i++];
            else if(nums1[i] < nums2[j]) nums[k] = nums1[i++];
            else nums[k] = nums2[j++];
        }
        System.out.println(Arrays.toString(nums));
        if(len % 2 == 1){
            return nums[len/2];
        }else{
            return (nums[len/2] + nums[len/2 - 1]) / 2.0;
        }
    }
}

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5, 6 };
        int[] nums2 = { 2, 3, 4, 5 };
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}