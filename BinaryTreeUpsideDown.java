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
    TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }
        dfs(root);
        return newRoot;
    }
    void dfs(TreeNode curr){
        TreeNode left = curr.left;
        TreeNode right = curr.right;
        if(left == null){
            newRoot = curr;
            return;
        }
        dfs(curr.left);
        curr.left.right = curr;
        curr.left.left = curr.right;
        curr.left = null;
        curr.right = null;
    }
}