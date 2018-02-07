class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int len = nums.length;
        if(len == 0){
            ans[0] = ans[1] = -1;
            return ans;
        }
        int l = 0, r = nums.length - 1;

        while(r-l > 1){
            int mid = l + (r-l)/2;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(nums[l] == target){
            ans[0] = l;
        }else if(nums[r] == target){
            ans[0] = r;
        }else{
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        l = ans[0];
        r = nums.length -1;
        while(r-l > 1){
            int mid = l + (r-l)/2;
            if(nums[mid] > target){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(nums[l] == target){
            ans[1] = l;
        }
        if(nums[r] == target){
            ans[1] = r;
        }
        return ans;
    }
}