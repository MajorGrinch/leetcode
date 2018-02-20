import java.util.*;

/**
 * recursive version
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Queue<Integer> qn = new LinkedList<>();
        if(root == null){
            return ans;
        }
        preorder(root);
        return ans;
    }
    void preorder(TreeNode current){
        ans.add(current.val);
        if(current.left != null){
            preorder(current.left);
        }
        if(current.right != null){
            preorder(current.right);
        }
        return;
    }
}
/**
 * iterative version
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode current = st.pop();
            ans.add(current.val);
            if(current.right != null){
                st.push(current.right);
            }
            if(current.left != null){
                st.push(current.left);
            }
        }
        return ans;
    }

}