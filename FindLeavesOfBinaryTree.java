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
    Map<Integer, List<Integer>> hmap = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int maxD = dfs(root);
        for(int i = 1; i <= maxD; i++){
            ans.add(hmap.get(i));
        }
        return ans;
    }
    int dfs(TreeNode curr){
        if(curr == null){
            return 0;
        }
        int leftD = dfs(curr.left);
        int rightD = dfs(curr.right);
        int d = Math.max(leftD, rightD) + 1;
        hmap.putIfAbsent(d, new ArrayList<>());
        hmap.get(d).add(curr.val);
        return d;
    }
}