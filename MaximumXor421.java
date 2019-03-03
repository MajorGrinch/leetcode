import java.util.*;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, ans = 0;
        for(int i = 31; i >= 0; i--){
            mask |= (1 << i);
            Set<Integer> prefixSet = new HashSet<>();
            for(int num : nums){
                prefixSet.add(num & mask);
            }
            int tmpAns = ans | (1<<i);
            for(int prefix : prefixSet){
                if(prefixSet.contains(tmpAns ^ prefix)){
                    ans = tmpAns;
                    break;
                }
            }
        }
        return ans;
    }
}