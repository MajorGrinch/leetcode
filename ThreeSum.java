import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int l = i+1, r = nums.length-1, target = -nums[i];
                while(l < r){
                    if(nums[l] + nums[r] == target){
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++; r--;
                    }else if(nums[l] + nums[r] < target){
                        l++;
                    }else{
                        r--;
                    }
                } 
            }
        }
        return ans;
    }
}
public class ThreeSum{
    public static void main(String[] args) {
        // int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0};
        for(List<Integer> l : new Solution().threeSum(nums)){
            System.out.println(l);
        }
    }
}