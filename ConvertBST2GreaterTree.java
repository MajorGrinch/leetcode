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
    int currSum = 0;
    void dfs(TreeNode curr){
        if(curr == null){
            return;
        }
        dfs(curr.right);
        currSum += curr.val;
        curr.val = currSum;
        dfs(curr.left);
        
    }
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        dfs(root);
        return root;   
    }
}