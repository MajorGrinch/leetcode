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

class Solution2{
    public int findDuplicate(int[] nums){
        int tortoise = nums[0];
        int hare = nums[nums[0]];
        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }
        int ptr1 = nums[0];
        int ptr2 = nums[tortoise];
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}

public class FindDuplicateNumber{
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4};
        Solution s = new Solution();
        s.findDuplicate(nums);
    }
}