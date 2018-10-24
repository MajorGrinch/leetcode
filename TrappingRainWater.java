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

class Solution2{
    public int trap(int[] height){
        int ans = 0;
        int len = height.length;
        int[] maxl = new int[len];
        int[] maxr = new int[len];
        maxl[0] = height[0];
        maxr[len-1] = height[len-1];
        for(int i = 1; i < len; i++){
            maxl[i] = Math.max(maxl[i-1], height[i]);
        }
        for(int i = len - 2; i >= 0; i--){
            maxr[i] = Math.max(maxr[i+1], height[i]);
        }
        for(int i = 1; i <= len - 2; i++){
            ans += Math.min(maxl[i], maxr[i]) - height[i];
        }
        return ans;
    }
}