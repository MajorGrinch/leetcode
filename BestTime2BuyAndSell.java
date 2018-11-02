class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] trend = new int[prices.length-1];
        for(int i = 1; i < prices.length; i++){
            trend[i-1] = prices[i] - prices[i-1];
        }
        int ans = findMaxSubarray(trend, 0, trend.length-1);
        return ans > 0 ? ans : 0;
    }
    int findMaxSubarray(int[] trend, int low, int high){
        if(high == low) return trend[low];
        int mid = low + (high-low) / 2;
        int leftSum = findMaxSubarray(trend, low, mid);
        int rightSum = findMaxSubarray(trend, mid+1, high);
        int crossSum = maxCrossArray(trend, low, mid, high);
        return Math.max((leftSum>rightSum ? leftSum : rightSum), crossSum);
    }
    int maxCrossArray(int[] trend, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= low; i--){
            sum += trend[i];
            if(sum > leftSum) leftSum = sum;
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid+1; i <= high; i++){
            sum += trend[i];
            if(sum > rightSum) rightSum = sum;
        }
        return leftSum + rightSum;
    }
}