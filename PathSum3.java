import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int pathSumFrom(TreeNode root, int sum){
        if(root == null) return 0;
        return (sum == root.val ? 1 : 0) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum-root.val);
    }
}
/**
 * preSum stores all prefix sum and how many ways to reach that sum
 * whenever reach a node, check whether current prefix sum - target
 * exist in preSum. If exist, then there must be preSum.get(currSum-target)
 * ways to get to target by current node.
 */
class Solution{
    public int pathSum(TreeNode root, int sum){
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }
    public int helper(TreeNode node, int currSum, int target, Map<Integer, Integer> preSum){
        if(node == null) return 0;
        currSum += node.val;
        int curr = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0)+1);
        curr += helper(node.left, currSum, target, preSum) + helper(node.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum)-1);
        return curr;
    }
}