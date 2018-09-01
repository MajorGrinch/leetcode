public class LongestSubstrWithAtMost2{
    public static void main(String[] args) {
        String input = "eceba";
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct2(input));
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
    public int lengthOfLongestSubstringTwoDistinct2(String s){
        int i = 0, numDistinct = 0, maxL = 0;
        int[] count = new int[256];
        for(int j = 0; j < s.length(); j++){
            if(count[s.charAt(j)] == 0) numDistinct++;
            count[s.charAt(j)]++;
            while(numDistinct > 2){
                count[s.charAt(i)]--;
                if(count[s.charAt(i)] == 0) numDistinct--;
                i++;
            }
            maxL = Math.max(maxL, j - i + 1);
        }
        return maxL;
    }
}