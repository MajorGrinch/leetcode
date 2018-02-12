import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Solution {
    /*
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> current_level = new Stack<>();
        Stack<TreeNode> next_level = new Stack<>();
        Stack<TreeNode> tmp = new Stack<>();

        current_level.push(root);
        boolean reverse = false;

        while(!current_level.isEmpty()){
            List<Integer> current_result = new ArrayList<>();
            while(!current_level.isEmpty()){
                TreeNode node = current_level.pop();
                current_result.add(node.val);
                if(reverse){
                    if(node.left != null){
                        next_level.push(node.left);
                    }
                    if(node.right != null){
                        next_level.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        next_level.push(node.right);
                    }
                    if(node.left != null){
                        next_level.push(node.left);
                    }
                }
            }
            ans.add(current_result);
            tmp = current_level;
            current_level = next_level;
            next_level = tmp;
            reverse = !reverse; 
        }
        return ans;
    }
}