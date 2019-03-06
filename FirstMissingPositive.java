import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) numSet.add(num);
        for(int i = 1; ; i++){
            if(!numSet.contains(i)) return i;
        }
    }
}