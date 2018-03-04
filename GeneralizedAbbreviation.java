import java.util.ArrayList;
import java.util.*;

class Solution {
    List<String> ans;
    public List<String> generateAbbreviations(String word) {
       ans = new ArrayList<>(); 
       dfs(0, "", false, word);
       Collections.reverse(ans);
       return ans;
    }
    void dfs(int start, String abbr, boolean abbred, String word){
        if(start == word.length()){
            ans.add(abbr);
            return;
        }
        dfs(start+1, abbr+word.charAt(start), false, word);
        if(!abbred){
            for(int i = start+1; i <= word.length(); i++){
                dfs(i, abbr+(i-start), true, word); 
            }            
        }
    }
}

public class GeneralizedAbbreviation{
    public static void main(String[] args) {
        String word = "word";
        List<String> ans = new Solution().generateAbbreviations(word);
        for(String str: ans){
            System.out.println(str);
        }
    }
}