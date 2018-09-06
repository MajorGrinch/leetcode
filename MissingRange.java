import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0 ){
            addRange(ans, (long)lower, (long)upper);
            return ans;
        }
        addRange(ans, lower, (long)nums[0]-1 );
        for(int i = 1; i < nums.length; i++){
            addRange(ans, (long)nums[i-1]+1, (long)nums[i]-1);
        }
        addRange(ans, (long)nums[nums.length-1]+1, (long)upper);
        return ans;
    }
    void addRange(List<String> ans, long st, long ed){
        if(st > ed){
            return;
        }
        if(st == ed){
            ans.add(st+"");
            return;
        }
        ans.add(st + "->" + ed);
    }

    public List<String> findMissingRanges2(int[] nums, int lower, int upper){
        List<String> ans = new ArrayList<>();
        long prev = (long)lower - 1;
        for(int i = 0; i <= nums.length; i++){
            long curr = (i==nums.length) ? (long)upper + 1 : nums[i];
            if(curr - prev >= 2){
                ans.add(getRange(prev+1, curr - 1));
            }
            prev = curr;
        }
        return ans;

    }
    private String getRange(long st, long ed){
        return (st == ed) ? String.valueOf(st) : (st + "->" + ed);
    }
}