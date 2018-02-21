/**
 * BFS version
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> qt = new LinkedList<>();
        qt.offer(root);
        while(!qt.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int len = qt.size();
            for(int i = 0; i < len; i++){
                TreeNode n = qt.poll();
                level.add(n.val);
                if(n.left != null){
                    qt.offer(n.left);
                }
                if(n.right != null){
                    qt.offer(n.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
    
}

/**
 * DFS version
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        dfs(root, 0, ans);
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