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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        inorderSum(root);
        return ans;
    }
    
    int inorderSum(TreeNode curr){
        if(curr == null){
            return 0;
        }
        int left = Math.max(inorderSum(curr.left), 0);
        int right = Math.max(inorderSum(curr.right), 0);
        ans = Math.max(ans, left+right+curr.val);
        return Math.max(left, right) + curr.val;
    }
}