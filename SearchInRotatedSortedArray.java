class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = nums.length-1;
        while(r-l > 1){
            int mid = l + (r-l)/2;
            if(nums[l] < nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid;
                }else{
                    l = mid;
                }
            }else{
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid;
                }else{
                    r = mid;
                }
            }
        }
        if(nums[l] == target){
            return l;
        }
        if(nums[r] == target){
            return r;
        }
        return -1;
    }
}