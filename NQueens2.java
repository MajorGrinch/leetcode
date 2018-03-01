class Solution {
    int count;
    public int totalNQueens(int n) {
        count = 0;
        if(n == 0){
            return count;
        }
        int[] rowArray = new int[n];
        Arrays.fill(rowArray, -1);
        dfs(rowArray, 0, n);
        return count;
    }
    void dfs(int[] rowArray,int k, int n){
        if(k == n){
            count++;
            return;
        }
        for(int j = 0; j < n; j++){
            if(!isConflict(rowArray, k, j)){
                continue;
            }
            rowArray[k] = j;
            dfs(rowArray, k+1, n);
        }
    }
    boolean isConflict(int[] rowArray, int rowIndex, int col){
        int n = rowArray.length;
        for(int i = 0; i < rowIndex; i++){
            if(rowArray[i] == col){
                return false;
            }
            if(rowArray[i] - col == i - rowIndex){
                return false;
            }
            if(rowArray[i] - col == rowIndex - i){
                return false;
            }
        }
        return true;
    }
}