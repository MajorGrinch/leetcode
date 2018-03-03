import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        int ans = s.length() - (set.size()-1);
        return ans;
    }
    public int longestPalindrome2(String s){
        int[] map = new int[128];
        int res = 0;
        for(char c : s.toCharArray()){
            if(map[c]++ % 2 == 1){
                res += 2;
            }
        }
        return s.length() > res ? res + 1 : res;
    }
}


public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abccccdd";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2(str));
    }
}