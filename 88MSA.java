class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int idx = m + n - 1;
        while(idx >= 0){
            if(nums1[i] > nums2[j]){
                nums1[idx--] = nums1[i--];
            }else{
                nums1[idx--] = nums2[j--];
            }
        }
    }
}