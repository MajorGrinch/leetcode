class Solution {
    public boolean canPartition(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int sum = 0;
        for(int num: nums){
            sum += num;
            cntMap.put(num, cntMap.getOrDefault(num, 0)+1);
        }
        if(sum % 2 == 1){
            return false;
        }
        boolean[][] dp = new boolean[nums.length+1][sum/2+1];
        dp[0][0] = true;

        for(int i = 1; i < dp.length; i++){
            dp[i][0] = true;
        }
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= nums[i-1])
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}