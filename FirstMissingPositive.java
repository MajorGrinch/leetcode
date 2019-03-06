import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) numSet.add(num);
        for(int i = 1; ; i++){
            if(!numSet.contains(i)) return i;
        }
    }
}

class Solution2{
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]){
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return n+1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp =  nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}