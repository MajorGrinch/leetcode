class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        else if(s != null && t != null){
            return isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t) ;
        }
        else{
            return false;
        } 
    }
    private boolean isIdentical(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        else if(r1 != null && r2 != null){
            if(r1.val != r2.val) return false;
            return isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
        }
        else{
            return false;
        }
    }
}

public class SubtreeOfAnother{
    public static void main(String[] args) {
        String input1 = "[4,1,2,0]";
        String input2 = "[3,4,5,1,2]";
        Solution slu = new Solution();
        TreeNode t = String2Tree.stringToTree(input1);
        TreeNode s = String2Tree.stringToTree(input2);
        System.out.println(slu.isSubtree(s, t));
    }
}