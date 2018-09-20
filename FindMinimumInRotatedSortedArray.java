class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int temp = nums[r];
        while(r-l > 1){
            int mid = l + (r-l) / 2;
            if(nums[mid] <= temp){
                r = mid;
            }else{
                l = mid;
            }
        }
        return (nums[l] <= nums[r]) ? nums[l] : nums[r];        
    }
}

class Solution2{
    public int findMin(int[] nums){
        int l = 0, r = nums.length - 1;
        int temp = nums[r];
        while(l < r){
            int mid = l + (r-l) / 2;
            if(nums[mid] <= temp){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return nums[l];
    }
}