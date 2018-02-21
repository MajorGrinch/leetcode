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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        dfs(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }
    void dfs(TreeNode curr, int depth, List<List<Integer>> ans){
        if(curr == null){
            return;
        }
        if(ans.size() == depth){
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(curr.val);
        dfs(curr.left, depth+1, ans);
        dfs(curr.right, depth+1, ans);
    }
}