class Solution {
    public int maxProduct(int[] nums) {
        int maxHere = nums[0], minHere = nums[0], maximum = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmpMaxHere = maxHere;
            maxHere = Math.max(maxHere*nums[i], Math.max(nums[i], minHere*nums[i]));
            minHere = Math.min(minHere*nums[i], Math.min(nums[i], tmpMaxHere*nums[i]));
            maximum = Math.max(maximum, maxHere);
        }
        return maximum;
    }
}