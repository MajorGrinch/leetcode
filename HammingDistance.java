class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int ans = 0;
        while(xor > 0){
            if((xor & 1) == 1){
                ans++;
            }
            xor >>>= 1;
        }
        return ans;
    }
}