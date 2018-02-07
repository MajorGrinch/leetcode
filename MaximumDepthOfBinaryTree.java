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
    public int maxDepth(TreeNode root) {
        int depth = dfs(root);
        return depth;
    }
    int dfs(TreeNode cur){
        if(cur == null){
            return 0;
        }
        int leftD = dfs(cur.left);
        int rightD = dfs(cur.right);
        int d = Math.max(leftD, rightD)+1;
        return d;
    }
}