import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> jewelSet = new HashSet<>();
        for(char c : J.toCharArray())
            jewelSet.add(c);
        for(char s : S.toCharArray()){
            if(jewelSet.contains(s))
                ans++;
        }
        return ans;
    }
}