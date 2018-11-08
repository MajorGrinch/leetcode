class Solution {
    public void moveZeroes(int[] nums) {
        int insertIdx = 0;
        for(int num : nums){
            if(num != 0){
                nums[insertIdx++] = num;
            }
        }
        for(int i = insertIdx; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}