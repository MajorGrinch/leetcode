class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for(int num : nums){
            sum += num;
            if(preSum.containsKey(sum-k)){
                ans += preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}