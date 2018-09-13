class Solution {
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        traverse(root);
        return isBalance;
    }
    private int traverse(TreeNode curr){
        if(curr == null) return 0;
        int left_len = traverse(curr.left);
        int right_len = traverse(curr.right);
        if(Math.abs(left_len - right_len) > 1) isBalance = false;
        return Math.max(left_len, right_len) + 1;
    }
}
