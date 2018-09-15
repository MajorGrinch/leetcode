class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rows = n, cols = n;
        int row = 0, col = -1;
        int num = 1;
        while(true){
            for(int i = 0; i < cols; i++)
                ans[row][++col] = num++;
            if(--rows == 0) break;
            for(int i = 0; i < rows; i++)
                ans[++row][col] = num++;
            if(--cols == 0) break;
            for(int i = 0; i < cols; i++)
                ans[row][--col] = num++;
            if(--rows == 0) break;
            for(int i = 0; i < rows; i++)
                ans[--row][col] = num++;
            if(--cols == 0) break;
        }
        return ans;
    }
}