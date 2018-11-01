class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*
inorder traverse the binary tree and compare the node simultaneously
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
    boolean inOrder(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p != null && q != null){
            return p.val == q.val && inOrder(p.left, q.left) && inOrder(p.right, q.right);
        }
        return false;
    }
}