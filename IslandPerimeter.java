class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int lands = 0, neighbors = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    lands++;
                    if(i < m-1 && grid[i+1][j] == 1) neighbors++;
                    if(j < n-1 && grid[i][j+1] == 1) neighbors++;
                }
            }
        }
        // System.out.printf("lands = %d, neighbors = %d\n", lands, neighbors);
        return (4 * lands - 2 * neighbors);
    }
}

class Solution2{
    int ans = 0;
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, m, n, vis, grid);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int m, int n,  boolean[][] vis, int[][] grid){
        if(i < 0 || i == m || j < 0 || j == n || vis[i][j] || grid[i][j] == 0) return;
        vis[i][j] = true;
        ans += (j+1 >= n || grid[i][j+1] == 0) ? 1 : 0;
        ans += (j-1 < 0 || grid[i][j-1] == 0) ? 1 : 0;
        ans += (i+1 >= m || grid[i+1][j] == 0) ? 1 : 0;
        ans += (i-1 < 0 || grid[i-1][j] == 0) ? 1 : 0;
        dfs(i-1, j, m, n, vis, grid);
        dfs(i, j-1, m, n, vis, grid);
        dfs(i+1, j, m, n, vis, grid);
        dfs(i, j+1, m, n, vis, grid);
    }
}