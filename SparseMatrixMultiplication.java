class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int t = B[0].length;
        int[][] C = new int[n][t];
        List<List<Integer>> non_zero = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < t; j++){
                non_zero.add(new ArrayList<>());
                if(B[i][j] != 0){
                    non_zero.get(i).add(j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int k = 0; k < m; k++){
                if(A[i][k] == 0){
                    continue;
                }
                for(int j : non_zero.get(k)){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int t = B[0].length;
        int[][] C = new int[n][t];
        for(int i = 0; i < n; i++){
            for(int k = 0; k < m; k++){
                if(A[i][k] != 0){
                    for(int j = 0; j < t; j++){
                        if(B[k][j] != 0){
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }

            }
        }
        return C;
    }
}