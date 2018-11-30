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

class Solution2{
    public void rotate(int[] nums, int k){
        if(nums.length == 0 || k < 0) return;
        int len = nums.length;
        k %= len;
        reverseArray(nums, 0, len-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, len-1);
    }
    private void reverseArray(int[] nums, int st, int ed){
        while(st < ed){
            swap(nums, st, ed);
            st++;
            ed--;
        }
    }
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}