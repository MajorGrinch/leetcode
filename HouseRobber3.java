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

class Solution3{
    public int rob(TreeNode root){
        int[] ans = robSub(root);
        return Math.max(ans[0], ans[1]);
    }
    /**
     * left[0] means max profit by not rob left child
     * left[1] vice versa
     * and others are the same
     */
    private int[] robSub(TreeNode root){
        if(root == null) return new int[]{0, 0};
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}