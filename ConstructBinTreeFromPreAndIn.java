class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*
preorder [root, left, right]
inorder [left, root, right]
root is a single node, left and right are subtrees.
ridx is root index of the bin tree inorder array from instart to inend index.
we can divide the inorder[instart, inend] by the ridx, with root node of left 
substree correspond to the preorder[pstart+1] and root node of right subtree
correspond to the preorder[pstart+len(left)]. len(left) = ridx - instart + 1
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeFromInterval(0, 0, inorder.length-1, preorder, inorder);
    }

    TreeNode buildTreeFromInterval(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(inStart > inEnd || preStart >= preorder.length){ return null; }

        TreeNode curr = new TreeNode(preorder[preStart]);
        int ridx;
        for(ridx = 0; ridx < inorder.length; ridx++){
            if(inorder[ridx] == curr.val){
                break;
            }
        }
        curr.left = buildTreeFromInterval(preStart+1, inStart, ridx-1, preorder, inorder);
        curr.right = buildTreeFromInterval(preStart+ridx-inStart+1, ridx+1, inEnd, preorder, inorder);
        return curr;
    }

}