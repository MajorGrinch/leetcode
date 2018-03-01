import java.util.*;

class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        ans = new ArrayList<>();
        // for(int depth = 0; depth <= nums.length; depth++){
        //     dfs1(nums, 0, depth, new ArrayList<>());
        // }
        dfs2(nums, 0, new ArrayList<Integer>());
        return ans; 
    }
    /*
    DFS with fixed depth
    */
    void dfs1(int[] nums, int k, int max_depth, ArrayList<Integer> subset){
        if(max_depth == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        for(int i = k; i < nums.length; i++){
            subset.add(nums[i]);
            dfs1(nums, i+1, max_depth-1, subset);
            subset.remove(subset.size()-1);
        }
    }
    /*
    essentially this is a DP approach
    the subset of f(n) is the the subset of f(n-1) adding
    each element of subset of f(n-1) union with n
    */
    public List<List<Integer>> iterativeApproach(int[] nums){
        ans = new ArrayList<>();
        // Arrays.sort(nums);
        ans.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int curr_size = ans.size();
            // System.out.println("");
            for(int j = 0; j < curr_size; j++){
                ArrayList<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
    /**
     * another dfs approach
     */
    void dfs2(int[] nums, int start, List<Integer> subset){
        ans.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            dfs2(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        List<List<Integer>> ans = solution.subsets(nums);
        for(List<Integer> l : ans){
            System.out.println(l);
        }
    }
}