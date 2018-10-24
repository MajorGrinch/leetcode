import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i = nums.length-2; i >= 0; i--){
            if(nums[i] < nums[i+1]) break;
        }
        // impossible to get next
        if(i < 0){
            reverseArray(nums, 0, nums.length-1);
            return;
        }
        
        int j;
        for(j = nums.length-1; j > i; j--){
            if(nums[j] > nums[i]) break;
        }
        swapIndex(nums, i, j);
        reverseArray(nums, i+1, nums.length-1);

    }
    public static void reverseArray(int[] nums, int st, int ed){
        int mid =(ed-st)/2 + 1;
        for(int i = 0; i < mid; i++){
            swapIndex(nums, st+i, ed-i);
        }
    }
    public static void swapIndex(int[] nums, int idx1, int idx2){
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

public class NextPermutation{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Solution s = new Solution();
        for(int i = 0; i < 120; i++){
            s.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}