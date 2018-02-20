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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeNode pre = null;
        stack.push(root);
        while(!stack.empty()){
            TreeNode curr = stack.peek();
            if(pre == null || pre.left == curr || pre.right == curr){
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }
            }else if(curr.left == pre){
                if(curr.right != null){
                    stack.push(curr.right);
                }
            }else{
                ans.add(curr.val);
                stack.pop();
            }
            pre = curr;
        }
        return ans;
    }
}