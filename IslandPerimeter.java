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