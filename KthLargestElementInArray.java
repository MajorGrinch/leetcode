import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int pvt = partition(nums, lo, hi);
            if (pvt < k)
                lo = pvt + 1;
            else if (pvt > k)
                hi = pvt - 1;
            else break;
        }
        return nums[k];
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] < v) {
                if (i == hi)
                    break;
            }
            while (nums[--j] > v) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }
}

class Solution2{
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, nums.length-k);
    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int[] nums, int lo, int hi, int k) {
        if(lo >= hi){
            return nums[k];
        }
        int i = lo, j = hi;
        int pvt = nums[lo + (hi-lo)/2];
        while(i <= j){
            while(i <= j && nums[i] < pvt){
                i++;
            }
            while(i <= j && nums[j] > pvt){
                j--;
            }
            if(i <= j){
                exch(nums, i++, j--);
            }
        }
        if(i <= k){
            partition(nums, i, hi, k);
        }
        if(j >= k){
            partition(nums, lo, j, k);
        }
        //if k lies between j and i then it's already in the right place
        return nums[k];
    }
}

public class KthLargestElementInArray{
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        // int[] nums = {11,11,11};
        int ans = new Solution2().findKthLargest(nums, 4);
        System.out.println(ans);
    }
}