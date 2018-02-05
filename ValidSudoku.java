class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] vis = new boolean[9];
        //row check
        for(int i = 0; i < 9; i++){
            Arrays.fill(vis, false);
            for(int j = 0; j < 9; j++){
                if( !check(vis, board[i][j]) ){
                    return false;
                }
            }
        }
        //col check
        for( int i = 0; i < 9; i++){
            Arrays.fill(vis, false);
            for(int j = 0; j < 9; j++){
                if( !check(vis, board[j][i]) ){
                    return false;
                }
            }
        }
        
        //subbox check
        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                Arrays.fill(vis, false);
                for(int k = 0; k < 9; k++){
                    if( !check(vis, board[i+k/3][j+k%3]) ){
                        return false;
                    }
                }
            }
        }
        return true;   
    }
    boolean check(boolean[] vis, char c){
        if(c == '.'){
            return true;
        }
        int num = c - '0';
        if( num < 1 || num > 9 || vis[num-1]){
            return false;
        }
        vis[num-1] = true;
        return true;
    }
}