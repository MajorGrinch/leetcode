class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < vis.length; i++){
            Arrays.fill(vis[i], false);
        }
        boolean ans = false;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                ans |= dfs(board, word, 0, vis, i, j, m, n);
                if(ans) return true;
            }
        return false;
    }
    boolean dfs(char[][] board, String word, int nxt_pos, boolean[][] vis, int cx, int cy, int m, int n){
        if(nxt_pos == word.length()) return true;
        if(cx < 0 || cx >= m || cy < 0 || cy >= n) return false;
        if(board[cx][cy] != word.charAt(nxt_pos) || vis[cx][cy] ) return false;

        vis[cx][cy] = true;

        boolean exist = dfs(board, word, nxt_pos+1, vis, cx+1, cy, m, n) || dfs(board, word, nxt_pos+1, vis, cx-1, cy, m, n)
                || dfs(board, word, nxt_pos+1, vis, cx, cy+1, m, n) || dfs(board, word, nxt_pos+1, vis, cx, cy-1, m, n);
        
        vis[cx][cy] = false;
        return exist;
    }
}