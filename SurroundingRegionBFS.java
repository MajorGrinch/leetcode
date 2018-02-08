class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0){
            return;
        }
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            bfs(board, i, 0, m, n);
            bfs(board, i, n-1, m, n);
        }
        for(int i = 0; i < n; i++){
            bfs(board, 0, i, m, n);
            bfs(board, m-1, i, m, n);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'W'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    void bfs(char[][] board, int bx, int by, int m, int n){
        if(board[bx][by] != 'O'){
            return;
        }
        int[] dx = { 0, 0, 1, -1};
        int [] dy = {1, -1, 0, 0};
        
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(bx);
        qy.offer(by);
        board[bx][by] = 'W';
        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if( nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O'){
                    board[nx][ny] = 'W';
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
    }
}