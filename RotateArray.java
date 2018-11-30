class Solution {
    public void rotate(int[] nums, int k){
        if(nums.length == 0 || k < 0) return;
        int len = nums.length;
        k %= len;
        for(int i = 0; i < k; i++){
            rotateByOne(nums);
        }
    }
    private void rotateByOne(int[] nums){
        int tmp = nums[nums.length-1];
        for(int i = nums.length-1; i > 0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = tmp;
    }
}