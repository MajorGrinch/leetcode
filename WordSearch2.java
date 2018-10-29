class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0) return ans;
        if(words.length == 0) return ans;
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(String word: words){
            boolean wordExist = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    wordExist |= dfs(board, word, 0, vis, i, j, m, n);
                    if(wordExist) break;
                }
                if(wordExist) break;
            }
            if(wordExist) ans.add(word);
        }
        return ans;
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