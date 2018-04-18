import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 18};
        int target = 29;
        System.out.println(Arrays.toString(new Solution2().twoSum(input, target)));
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int j = binSearch(numbers, target-numbers[i], i);
            if(j != -1){
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    private int binSearch(int[] nums, int target, int start) {
        int l = start, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (l == r && nums[l] == target) ? l : -1;
    }
}
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }else if(sum == target){
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}