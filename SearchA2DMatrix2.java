class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length - 1, c = 0;
        int count = 0;
        while(r>=0 && c < matrix[0].length){
            if(matrix[r][c] == target){
                count++;
                r--;
                c++;
            }else if(matrix[r][c] > target){
                r--;
            }else{
                //matrix[r][c] < target
                c++;
            }
        }
        return count != 0;
    }
}