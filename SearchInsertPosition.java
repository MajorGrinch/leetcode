class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target)
                return i;
        }
        return nums.length;
    }
}

class Solution2{
    public int searchInsert(int[] nums, int target){
        return binSearch(nums, 0, nums.length-1, target);
    }
    private int binSearch(int[] nums, int lo, int hi, int target){
        if(nums[lo] > target) return lo;
        if(nums[hi] < target) return hi + 1;
        if(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) return binSearch(nums, mid+1, hi, target);
            else return binSearch(nums, lo, mid-1, target);
        }
        return -1;
    }
}

class Solution3{
    public int searchInsert(int[] nums, int target){
        int L = 0, R = nums.length - 1;
        while(L < R){
            int mid = L + (R-L)/2;
            if(nums[mid] < target){
                L = mid + 1;
            }else{
                R = mid;
            }
        }
        return nums[L] < target ? L+1 : L;
    }
}
public class SearchInsertPosition{
    public static void main(String[] args) {
        int[] test = {1,3,5,6};
        int ans = new Solution2().searchInsert(test, 7);
        System.out.println(ans);
    }
}