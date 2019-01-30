class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int cnt = 1;
        int last = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != last){
                last = nums[i];
                nums[cnt++] = last;
            }
        }
        return cnt;
    }
}