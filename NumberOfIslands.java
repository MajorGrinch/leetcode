class Solution {
    boolean[][] vis;
    int count = 0;
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        vis = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] =='1' && !vis[i][j]){
                    bfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }
    void bfs(char[][] grid, int x, int y, int row, int col){
        count++;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(x);
        qy.offer(y);
        while(!qx.isEmpty()){
            int current_x = qx.poll();
            int current_y = qy.poll();
            for(int i = 0; i < 4; i++){
                int nxt_x = current_x + dx[i];
                int nxt_y = current_y + dy[i];
                if(nxt_x >= 0 && nxt_x < row && nxt_y >= 0 && nxt_y < col 
                    && !vis[nxt_x][nxt_y] && grid[nxt_x][nxt_y]=='1'){
                        vis[nxt_x][nxt_y] = true;
                        qx.offer(nxt_x);
                        qy.offer(nxt_y);
                    }
            }
        }
    }
}