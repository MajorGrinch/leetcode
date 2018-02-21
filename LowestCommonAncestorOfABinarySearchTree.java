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
        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode ans = searchLCA(root, p, q);
        return ans;
    }
    /* assume p.val < q.val */
    TreeNode searchLCA(TreeNode curr, TreeNode p, TreeNode q){
        if(p.val <= curr.val && q.val >= curr.val){
            return curr;
        }
        if(p.val < curr.val && q.val < curr.val){
            return searchLCA(curr.left, p, q);
        }
        if(p.val > curr.val && q.val > curr.val){
            return searchLCA(curr.right, p, q);
        }
        return null;
    }
}