class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int S) {
        ans = 0;
        dfs(nums, 0, nums.length, 0, S);
        return ans;
    }

    private void dfs(int[] nums, int pos, int len, int currSum, int S){
        if(pos == len && currSum == S){
            ans++;
            return;
        }
        if(pos < len){
            dfs(nums, pos+1, len, currSum+nums[pos], S);
            dfs(nums, pos+1, len, currSum-nums[pos], S);
        }
    }
}

class Solution{
    public int findTargetSumWays(int[] nums, int S){
        if(S > 1000) return 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        sum += S;
        if(sum % 2 == 1){
            return 0;
        }
        sum /= 2;
        int ans = subSetSum(nums, sum);
        return ans;
    }
    private int subSetSum(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[target];
    }
}