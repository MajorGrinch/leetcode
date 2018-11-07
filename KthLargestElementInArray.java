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