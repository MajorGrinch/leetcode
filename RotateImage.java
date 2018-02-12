class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return;
        }
        for(int r = 0; r < (n+1)/2; r++){
            for(int c = 0; c < n/2; c++){
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n-1-c][r];
                matrix[n-1-c][r] = matrix[n-1-r][n-1-c];
                matrix[n-1-r][n-1-c] = matrix[c][n-1-r];
                matrix[c][n-1-r] = tmp;
            }
        }
    }
}