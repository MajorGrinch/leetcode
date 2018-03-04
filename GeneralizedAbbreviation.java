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
    public List<String> generateAbbreviations2(String word) {
        ans = new ArrayList<>();
        for(int i = 0; i < (1<<word.length()); i++){
            parseBinary(word, i);
        } 
        return ans;
    }
    void parseBinary(String word, int x){
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i = 0; i < word.length(); i++){
            if((x & 1) == 0){
               // keep char
                if(k != 0){
                    sb.append(k);
                    k = 0;
                }
                sb.append(word.charAt(i));
            }else{
                k++;
            }
            x = x >> 1;
        }
        if(k != 0)
            sb.append(k);
        ans.add(sb.toString());
    }
}

public class GeneralizedAbbreviation{
    public static void main(String[] args) {
        String word = "word";
        List<String> ans = new Solution().generateAbbreviations2(word);
        for(String str: ans){
            System.out.println(str);
        }
    }
}