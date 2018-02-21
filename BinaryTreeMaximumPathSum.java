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
    class Result{
        int singlePath, maxPath;
        Result(int s, int m){
            this.singlePath = s;
            this.maxPath = m;
        }
    }
    public int maxPathSum(TreeNode root) {
        Result ans = searchRes(root);
        return ans.maxPath;
    }
    
    Result searchRes(TreeNode curr){
        if(curr == null){
            return new Result(0, Integer.MIN_VALUE);
        }
        Result left = searchRes(curr.left);
        Result right = searchRes(curr.right);
        int singlePath = Math.max(left.singlePath, right.singlePath) + curr.val;
        singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath+right.singlePath+curr.val);
        return new Result(singlePath, maxPath);
    }
}