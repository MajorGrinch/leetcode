class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        List<Integer> ans = new ArrayList<>();
        if(rows == 0) return ans;
        int cols = matrix[0].length;
        int row = 0, col = -1;
        while(1){
            for(int i = 0; i < cols; i++)
                ans.add(matrix[row][++col]);
            if(--rows == 0) break;
            for(int i = 0; i < rows; i++)
                ans.add(matrix[++row][col]);
            if(--cols == 0) break;
            for(int i = 0; i < cols; i++)
                ans.add(matrix[row][--col]);
            if(--rows == 0) break;
            for(int i = 0; i < rows; i++)
                ans.add(matrix[--row][col]);
            if(--cols == 0) break;
        }
        return ans;
    }
}