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

class Solution2{
    public String removeDuplicateLetters(String s){
        if(s.length() == 0) return s;
        int[] cnt = new int[26];
        char[] sc = s.toCharArray();
        for(char c : sc){
            cnt[c-'a']++;
        }
        Stack<Character> ansStack = new Stack<>();
        boolean[] used = new boolean[26];
        for(char c : sc){
            int idx = c - 'a';
            cnt[idx]--;
            if(used[idx]) continue;

            while(!ansStack.isEmpty() && ansStack.peek() > c && cnt[ansStack.peek()-'a'] > 0){
                used[ansStack.pop()-'a'] = false;
            }
            ansStack.push(c);
            used[c-'a'] = true;
        }
        StringBuffer res = new StringBuffer();
        for(char c : ansStack){
            res.append(c);
        }
        return res.toString();
    }
}

public class RemoveDuplicateLetters{
    public static void main(String[] args) {
        String input = "cbacdcbc";
        System.out.println(new Solution2().removeDuplicateLetters(input));
    }
}