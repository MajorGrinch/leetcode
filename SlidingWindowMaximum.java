class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[]{};
        int[] maxInWin = new int[nums.length - k + 1];
        Deque<Integer> idxMax = new ArrayDeque<>();
        int wink = 0;
        for(int i = 0; i < nums.length; i++){
            while(!idxMax.isEmpty() && idxMax.peekFirst() < i-k+1){
                idxMax.pollFirst();
            }
            while(!idxMax.isEmpty() && nums[idxMax.peekLast()] < nums[i]){
                idxMax.pollLast();
            }
            idxMax.offer(i);
            if(i >= k-1){
                maxInWin[wink++] = nums[idxMax.peekFirst()];
            }
        }
        return maxInWin;
    }
}