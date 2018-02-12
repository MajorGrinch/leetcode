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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer, List<Integer>> hmap = new HashMap<>();
        Queue<TreeNode> qn = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        qn.offer(root);
        qc.offer(0);
        while(!qn.isEmpty()){
            int current_col = qc.poll();
            TreeNode current_node = qn.poll();
            hmap.putIfAbsent(current_col, new ArrayList<>());
            hmap.get(current_col).add(current_node.val);
            if(current_node.left != null){
                qn.offer(current_node.left);
                qc.offer(current_col - 1);
            }
            if(current_node.right != null){
                qn.offer(current_node.right);
                qc.offer(current_col + 1);
            }
        }
        for(int i = Collections.min(hmap.keySet()); i <= Collections.max(hmap.keySet()); i++){
            ans.add(hmap.get(i));
        }
        return ans;
    }
}