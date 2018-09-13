public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBst(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBst(int[] nums, int st, int ed){
        if(st > ed) return null;
        int mid = st + (ed-st) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = sortedArrayToBst(nums, st, mid-1);
        curr.right = sortedArrayToBst(nums, mid+1, ed);
        return curr;
    }
}