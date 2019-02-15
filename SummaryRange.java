import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int st = nums[i];
            for(int j = i+1; j < nums.length && nums[j]-nums[i] == 1; i++, j++);
            int ed= nums[i];
            ans.add(getRange(st, ed));
        }

        return ans;
    }

    private String getRange(int st, int ed){
        if(st == ed){
            return String.valueOf(st);
        }
        return st + "->" + ed;
    }
}