/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "{}";
        }
        List<TreeNode> qn = new ArrayList<>();
        qn.add(root);
        for(int i = 0; i < qn.size(); i++){
            TreeNode n = qn.get(i);
            if(n == null){
                continue;
            }
            qn.add(n.left);
            qn.add(n.right);
        }
        while(qn.get(qn.size()-1) == null){
            qn.remove(qn.size()-1);
        }
        StringBuilder sb = new StringBuilder("{");
        sb.append(qn.get(0).val);
        for(int i = 1; i < qn.size(); i++){
            if(qn.get(i) == null){
                sb.append(",#");
            }else{
                sb.append(","+qn.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("{}")){
            return null;
        }
        String[] nodes_str = data.substring(1, data.length()-1).split(",");
        List<TreeNode> qn = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes_str[0]));
        qn.add(root);
        boolean isLeft = true;
        int father_idx = 0;
        for(int i = 1; i < nodes_str.length; i++){
            if(!nodes_str[i].equals("#")){
                TreeNode n = new TreeNode(Integer.parseInt(nodes_str[i]));
                if(isLeft){
                    qn.get(father_idx).left = n;
                }else{
                    qn.get(father_idx).right = n;
                }
                qn.add(n);
            }
            if(!isLeft){
                father_idx++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));