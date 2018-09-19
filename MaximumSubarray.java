class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndHere = nums[0], maximum = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxEndHere = Math.max(maxEndHere+nums[i], nums[i]);
            maximum = Math.max(maxEndHere, maximum);
        }
        return maximum;
    }
}