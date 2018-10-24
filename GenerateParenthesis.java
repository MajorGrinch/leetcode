import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        dfs(sb, 0, 0, n, ans);
        return ans;
    }
    void dfs(StringBuilder sb, int open, int close, int n, List<String> ans){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            dfs(sb.append('('), open+1, close, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            dfs(sb.append(')'), open, close+1, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

public class GenerateParenthesis{
    public static void main(String[] args) {
        List<String> output = new Solution().generateParenthesis(3);
        System.out.println(output);
    }
}