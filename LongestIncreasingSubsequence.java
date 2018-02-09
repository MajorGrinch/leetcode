/*
DP + Binary Search
Time O(nlogn)
Space O(n)
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        for(int num : nums){
            int idx = Arrays.binarySearch(dp, 0, len, num);
            if(idx < 0){
                idx = -(idx+1);
            }
            dp[idx] = num;
            if(idx == len){
                len++;
            }
        }
        return len;
    }
}

/*
DP
Time O(n^2)
Space O(n)
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1){
            return len;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int maxL = 1;
        for(int i = 1; i < len; i++){
            int temp = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }
}