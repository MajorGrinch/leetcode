import java.util.HashSet;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        int[] tmap = new int[256];
        int[] winmap = new int[256];
        int[] auxtmap = new int[256];
        int remain = t.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            tmap[t.charAt(i)]++;
            auxtmap[t.charAt(i)]++;
            set.add(t.charAt(i));
        }
        int l = 0;
        int r;
        int tmp = remain;
        for(r = 0; r < s.length(); r++){
            if(auxtmap[s.charAt(r)] > 0){
                if(remain == tmp) l = r;
                auxtmap[s.charAt(r)]--;
                remain--;
            }
            winmap[s.charAt(r)]++;
            if(remain == 0) break;
        }
        if(r == s.length()) return "";
        String ans = s.substring(l, r+1);
        // System.out.println("l = " + l + " r = " + r);
        // printWinmap(winmap);
        while(r < s.length()){
            char c = s.charAt(l++);
            winmap[c]--;
            if(set.contains(c) && winmap[c] < tmap[c]){
                while(++r < s.length() && s.charAt(r) != c){
                    winmap[s.charAt(r)]++;
                }
                if(r == s.length()) break;
                winmap[s.charAt(r)]++;
            }else{
                ans = (ans.length() > (r-l+1) ? s.substring(l, r+1) : ans);
            }
            // printWinmap(winmap);
            // System.out.println(ans + " " + s.substring(l, r+1));
        }
        return ans;
    }
    void printWinmap(int[] map){
        for(int i = 0; i < map.length; i++){
            if(map[i] > 0){
                System.out.print((char)i+ ":" + map[i] + " ");
            }
        }
        System.out.println();
    }
}

public class MinimumWindowSubstring{
    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        Solution sol = new Solution();
        System.out.println(sol.minWindow(s, t));
    }
}