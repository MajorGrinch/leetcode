public class LongestSubstrWithAtMost2{
    public static void main(String[] args) {
        String input = "caabbc";
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct(input));
    }
}

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1, maxL = 0;
        for(int k = 1; k < s.length(); k++){
            if(s.charAt(k) == s.charAt(k-1)) continue;
            if(j >= 0 && s.charAt(k) != s.charAt(j)){
                maxL = Math.max(maxL, k-i);
                i = j+1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, maxL);
    }
}