class Solution {
    public boolean canJump(int[] nums) {
        int st = nums.length - 1;
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        for(int i = 0; i < nums.length-1; i++){
            if(reach[i])
                for(int k = 1; k <= nums[i] && k+i < nums.length; k++){
                    reach[i+k] = true;
                }
        }
        return reach[nums.length-1];
    }

}

public class JumpGame{
    public static void main(String[] args) {
        int[] input = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(new Solution().canJump(input));
    }
}