import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
}

public class FindDuplicateNumber{
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4};
        Solution s = new Solution();
        s.findDuplicate(nums);
    }
}