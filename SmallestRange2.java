class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);

        int len = A.length;
        int ans = A[len - 1] - A[0];
        for(int i = 0; i < len - 1; i++){
            int high = Math.max(A[i] + K, A[len-1] -K);
            int low = Math.min(A[i+1] - K, A[0] + K);
            ans = Math.min(ans, high-low);
        }
        return ans;
    }
}