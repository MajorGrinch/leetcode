class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        int[] rowArray = new int[n];
        Arrays.fill(rowArray, -1);
        dfs(rowArray, 0, n);
        return ans;  
    }
    void dfs(int[] rowArray,int k, int n){
        if(k == n){
            List<String> ans_item = drawBoard(rowArray, n);
            ans.add(ans_item);
            return;
        }
        for(int j = 0; j < n; j++){
            if(!isConflict(rowArray, k, j)){
                continue;
            }
            rowArray[k] = j;
            dfs(rowArray, k+1, n);
            rowArray[k] = -1;
        }
    }
    List<String> drawBoard(int[] rowArray, int n){
        List<String> board = new ArrayList<>();
        for(int j = 0; j < n; j++){
            StringBuilder row = new StringBuilder();
            for(int i = 0; i  < n; i++){
                row.append( (i==rowArray[j]) ? 'Q' : '.');
            }
            board.add(row.toString());
        }
        return board;
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