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

public class Solution {
    /*
     * @param matrix: a lists of integers
     * @return: 
     */
    public void rotate(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if(n == 0){
            return;
        }
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}