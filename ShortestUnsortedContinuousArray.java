class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = -1, r = nums.length;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                l = i;
                break;
            }
        }
        if(l == -1) return 0;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i] < nums[i-1]){
                r = i;
                break;
            }
        }
        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            maxTemp = Math.max(maxTemp, nums[i]);
            minTemp = Math.min(minTemp, nums[i]);
        }
        for(int i = 0; i < l; i++){
            if(nums[i] > minTemp){
                l = i;
                break;
            }
        }
        for(int i = nums.length-1; i > r; i--){
            if(nums[i] < maxTemp){
                r = i;
                break;
            }
        }
        return r - l + 1;
    }
}