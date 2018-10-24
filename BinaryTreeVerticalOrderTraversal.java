import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

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
class Solution2{
    Map<Integer, List<Integer>> colmap;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int minl = Integer.MAX_VALUE, maxl = Integer.MIN_VALUE;
        colmap = new HashMap<>();
        Queue<TreeNode> qn = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        qn.offer(root);
        qc.offer(0);
        while(!qn.isEmpty()){
            int col = qc.poll();
            TreeNode curr = qn.poll();
            minl = Math.min(col, minl);
            maxl = Math.max(col, maxl);
            colmap.putIfAbsent(col, new ArrayList<>());
            colmap.get(col).add(curr.val);
            if(curr.left != null){
                qn.offer(curr.left);
                qc.offer(col-1);
            }
            if(curr.right != null){
                qn.offer(curr.right);
                qc.offer(col+1);
            }
        }
        for(int i = minl; i <= maxl; i++){
            ans.add(colmap.get(i));
        }

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}