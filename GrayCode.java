import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        int iters = 1 << n;
        for(int i = 0; i < iters; i++){
            ans.add(i ^ i/2);
        }
        return ans;
    }
}
public class GrayCode{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.grayCode(4));
    }
}