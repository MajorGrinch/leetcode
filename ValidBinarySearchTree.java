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
    long last = Integer.MIN_VALUE;
    boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        last--;
        dfs(root);
        return valid;
    }
    
    void dfs(TreeNode cur){
        if(cur == null){
            return;
        }
        dfs(cur.left);
        if(last >= cur.val){
            valid = false;
            return;
        }else{
            last = cur.val;
        }
        dfs(cur.right);
    }
}