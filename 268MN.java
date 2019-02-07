import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n+1];
        Arrays.fill(seen, false);
        for(int num : nums){
            seen[num] = true;
        }
        int ans = -1;
        for(int i = 0; i <= n; i++){
            if(!seen[i]){
                ans = i;
                break;
            }
        }
        return ans;
    }
}