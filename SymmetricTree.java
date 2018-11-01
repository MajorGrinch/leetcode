/* 
preorder traverse the left and right child of root and compare them simultaneously.
But for this problem, compare them in a symmetric way where you compare p.left with
q.right and p.right with q.left to check for symmetry.
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetricTraverse(root.left, root.right);
    }
    boolean symmetricTraverse(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p != null && q != null){
            return p.val == q.val && symmetricTraverse(p.left, q.right) && symmetricTraverse(p.right, q.left);
        }
        return false;
    }
}