import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return s;
        Map<Character, Integer> lastOccr = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            lastOccr.put(s.charAt(i), i);
        }
        int uniqNum = lastOccr.size();
        StringBuffer ans = new StringBuffer();
        int begin = 0, end = findMinV(lastOccr);
        for(int i = 0; i < 30; i++){
            char minChar = 'z' + 1;
            for(int k = begin; k <= end; k++){
                if(lastOccr.containsKey(s.charAt(k)) && s.charAt(k) < minChar){
                    minChar = s.charAt(k);
                    begin = k + 1;
                }
            }
            ans.append(minChar);
            lastOccr.remove(minChar);
            end = findMinV(lastOccr);
            if(ans.length() == uniqNum) break;
        }
        return ans.toString();
    }

    private int findMinV(Map<Character, Integer> lastOccr){
        if(lastOccr.size() == 0) return -1;
        int res = Integer.MAX_VALUE;
        for(int idx : lastOccr.values()){
            res = Math.min(res, idx);
        }
        return res;
    }
}

public class RemoveDuplicateLetters{
    public static void main(String[] args) {
        String input = "cbacdcbc";
        System.out.println(new Solution().removeDuplicateLetters(input));
    }
}