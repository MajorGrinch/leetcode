import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=  new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }
    private void dfs(TreeNode node, List<Integer> view, int depth){
        if(node == null) return;
        if(view.size() <= depth){
            view.add(node.val);
        }
        dfs(node.right, view, depth+1);
        dfs(node.left, view, depth+1);
    }

}