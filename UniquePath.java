class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                mat[i][j] = -1;
        return backtrack(0, 0, m, n, mat);
    }
    private int backtrack(int row, int col, int m, int n, int[][] mat){
        if(row == m-1 || col == n-1) return 1;
        if(row > m-1 || col > n-1) return 0;
        if(mat[row+1][col] == -1)
            mat[row+1][col] = backtrack(row+1, col, m, n, mat);
        if(mat[row][col+1] == -1)
            mat[row][col+1] = backtrack(row, col+1, m, n, mat);
        return mat[row][col+1] + mat[row+1][col];
    }
}

class Solution2{
    public int uniquePaths(int m, int n){
        int[][] mat = new int[m+1][n+1];
        mat[m-1][n] = 1;
        for(int r = m-1; r >= 0; r--)
            for(int c = n-1; c >= 0; c--){
                mat[r][c] = mat[r+1][c] + mat[r][c+1];
            }
        return mat[0][0];
    }
}