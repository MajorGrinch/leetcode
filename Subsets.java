import java.util.*;

class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        ans = new LinkedList<>();
        Arrays.sort(nums);
        for(int depth = 0; depth <= nums.length; depth++){
            dfs(nums, 0, depth, new LinkedList<>());
        }
        return ans; 
    }
    void dfs(int[] nums, int k, int max_depth, LinkedList<Integer> subset){
        if(k == max_depth){
            ans.add(new LinkedList<>(subset));
            return;
        }
        for(int i = k; i < nums.length; i++){
            subset.add(nums[i]);
            dfs(nums, i+1, max_depth, subset);
            subset.removeLast();
        }
    }
}

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,1,0};
        List<List<Integer>> ans = solution.subsets(nums);
        for(List<Integer> l : ans){
            System.out.println(l);
        }
    }
}