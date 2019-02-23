class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbors = countNeighbor(board, i, j);
                if(neighbors < 2 || neighbors > 3){
                    //currently lived and will die next gen
                    if(board[i][j] == 1) board[i][j] = 2;
                }
                else if(neighbors == 3 && board[i][j] == 0){
                    //current dead but will live next gen
                    board[i][j] = -1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == -1) board[i][j] = 1;
            }
        }
    }

    private int countNeighbor(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        int cnt = 0;
        if(i > 0){
            if(j > 0) cnt += board[i-1][j-1] > 0 ? 1 : 0;
            cnt += board[i-1][j] > 0 ? 1 : 0;
            if(j+1 < n) cnt += board[i-1][j+1] > 0 ? 1 : 0;
        }
        if(j > 0) cnt += board[i][j-1] > 0 ? 1 : 0;
        if(j+1 < n) cnt += board[i][j+1] > 0 ? 1 : 0;
        if(i+1 < m){
            if(j > 0) cnt += board[i+1][j-1] > 0 ? 1 : 0;
            cnt += board[i+1][j] > 0 ? 1 : 0;
            if(j+1 < n) cnt += board[i+1][j+1] > 0 ? 1 : 0;
        }
        return cnt;
    }
}