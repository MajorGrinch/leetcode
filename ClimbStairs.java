class Solution {
    public int climbStairs(int n) {
        if(n < 2) return 1;
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        for(int i = 3; i < n+1; i++)
            ans[n] = ans[n-2] + ans[n-1];
        return ans[n];
    }
}