class Solution {
    public int rob(int[] nums) {
        int curr_max = 0;
        int prev_max = 0;
        for(int num : nums){
            int temp = curr_max;
            curr_max = Math.max(prev_max + num, curr_max);
            prev_max = temp;
        }
        return curr_max;

    }
}
/**
 * at the beginning of every iteration,
 * curr max is the max profit by robbing the last hourse without alert
 * prev max is the max profix by robbing the horse before the last one without alert
 * so you may update the curr_max to max profit sor far by either rob the last horse or not
 * 
 */

public class HorseRobber{
    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        // int[] nums = {2, 1, 1, 2};
        System.out.println(new Solution().rob(nums));
    }
}