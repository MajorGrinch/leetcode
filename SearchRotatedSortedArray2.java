class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if(nums.length == 0) return false;
        if(nums.length == 1) return nums[0] == target;

        while(l < r){
            int mid = l + (r-l >> 1);
            if(nums[mid] == target) return true;

            //right now nums[mid] != target
            //left is unordered or right is ordered
            if(nums[l] > nums[mid] || nums[mid] < nums[r]){
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else if(nums[l] < nums[mid] || nums[mid] > nums[r]){
                // left ir ordered or right is unordered
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                r--;
            }
        }
        return nums[l] == target;
    }
}