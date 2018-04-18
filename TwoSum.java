import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(input, target)));
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(target-num)){
                return new int[] {map.get(target-num), i};
            }
            map.put(num, i);
        }
        return new int[]{0,0};
    }
}