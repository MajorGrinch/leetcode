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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        ans = Math.max(ans, diameterFrom(root));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return ans;
    }
    private int diameterFrom(TreeNode node){
        if(node == null) return 0;
        int left = maxDepth(node.left, 0);
        int right = maxDepth(node.right, 0);
        return left + right;
    }
    private int maxDepth(TreeNode node, int curr){
        if(node == null) return curr;
        int left = maxDepth(node.left, curr+1);
        int right = maxDepth(node.right, curr+1);
        int ans = Math.max(left, right);
        return ans;
    }

}