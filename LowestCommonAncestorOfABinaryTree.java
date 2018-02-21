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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = LCA(root, p, q);
        return ans;
    }
    TreeNode LCA(TreeNode curr, TreeNode A, TreeNode B){
        if(curr == null){
            return null;
        }
        if(curr == A || curr == B){
            return curr;
        }
        TreeNode L = LCA(curr.left, A, B);
        TreeNode R = LCA(curr.right, A, B);
        if(L != null && R != null){
            return curr;
        }
        return (L!=null) ? L : R;
    }
}