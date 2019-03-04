class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int[] row : A){
            flipAndRevRow(row);
        }
        return A;
    }

    private void flipAndRevRow(int[] row){
        int i = 0, j = row.length-1;
        while(i < j){
            int tmp = row[i] ^ 1;
            row[i++] = row[j] ^ 1;
            row[j--] = tmp;
        }
        if(i == j) row[i] ^= 1;
    }
}