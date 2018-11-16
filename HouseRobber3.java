import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = 0;
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + val, rob(root.left)+rob(root.right)); 
    }
}

class Solution2{
    Map<TreeNode, Integer> hmap = new HashMap<>();
    public int rob(TreeNode root){
        if(root == null) return 0;
        if(hmap.containsKey(root)) return hmap.get(root);
        int robbed = root.val;
        if(root.left != null){
            robbed += rob(root.left.right) + rob(root.left.left);
        }
        if(root.right != null){
            robbed += rob(root.right.left) + rob(root.right.right);
        }
        int notRob = rob(root.left) + rob(root.right);
        int res = Math.max(robbed, notRob);
        hmap.put(root, res);
        return res;
    }
}