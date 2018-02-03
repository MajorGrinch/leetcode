class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int maxL = 1;
        for(int num: nums){
            s.remove(num);
            int tmpL = 1;
            int pre = num - 1;
            int nxt = num + 1;
            while(s.contains(pre)){
                s.remove(pre);
                tmpL++;
                pre--;
            }
            while(s.contains(nxt)){
                s.remove(nxt);
                tmpL++;
                nxt++;
            }
            maxL = Math.max(tmpL, maxL);
        }
        return maxL;
    }
}