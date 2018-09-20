import java.util.Arrays;
class Solution {
    public int maximumGap(int[] nums) {
        final int N = nums.length;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int num : nums){
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }
        int buk_size = (int)Math.ceil((double)(maxi - mini) / (N - 1));
        // System.out.println(buk_size);
        int[] bucket_min = new int[N-1];
        int[] bucket_max = new int[N-1];
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        for(int num : nums){
            if(num == maxi || num == mini) continue;
            int bukIdx = (num - mini) / buk_size;
            // System.out.println("bukIdx: "+bukIdx);
            bucket_max[bukIdx] = Math.max(bucket_max[bukIdx], num);
            bucket_min[bukIdx] = Math.min(bucket_min[bukIdx], num); 
        }
        // System.out.println("bucket_min: "+Arrays.toString(bucket_min));
        // System.out.println("bucket_max: "+Arrays.toString(bucket_max));
        int ans = Integer.MIN_VALUE;
        int prev_max = mini;
        for(int i = 0; i < N-1; i++){
            if(bucket_max[i] == Integer.MIN_VALUE && bucket_min[i] == Integer.MAX_VALUE)
                continue;
            ans = Math.max(ans, bucket_min[i] - prev_max);
            prev_max = bucket_max[i];
        }
        ans = Math.max(ans, maxi - prev_max);
        return ans;
    }
}

public class MaximumGap{
    public static void main(String[] args) {
        int[] input = {3,5,9,1};
        System.out.println(new Solution().maximumGap(input));
    }   
}