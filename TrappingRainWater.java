class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        for(int i = 1; i < len - 1; i++){
            int maxl = 0, maxr = 0;
            for(int j = i; j >= 0; j--){
                maxl = Math.max(maxl, height[j]);
            }
            for(int j = i; j < len; j++){
                maxr = Math.max(maxr, height[j]);
            }
            ans += Math.min(maxl, maxr) - height[i];
        }
        return ans;
    }
}