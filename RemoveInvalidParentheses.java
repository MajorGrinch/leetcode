import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        removeFromString(s, ans, 0, 0, new char[]{'(', ')'});
        // removeFromString(new StringBuilder(s).reverse().toString(), ans, 0, 0, new char[]{')', '('});
        return ans;
    }

    private void removeFromString(String s, List<String> ans, int lasti, int lastj, char[] par){
        int cnt = 0;
        System.out.println(s + " lasti: " + lasti + " lastj: " + lastj);
        for(int i = lasti; i < s.length(); i++){
            if(s.charAt(i) == par[0]) cnt++;
            if(s.charAt(i) == par[1]) cnt--;
            if(cnt >= 0) continue;
            for(int j = lastj; j <= i; j++){
                if(s.charAt(j) == par[1] && (j == lastj || s.charAt(j-1) != par[1]))
                    removeFromString(s.substring(0, j) + s.substring(j+1), ans, i, j, par);
            }
            return;
        }
        String rev = new StringBuilder(s).reverse().toString();
        if(par[0] == '('){
            /**
             * par[0] == '(' means that you have removed all invalid )
             * but you haven't removed all invalid (
             * so remove all invalid ( in this step
             */
            removeFromString(rev, ans, 0, 0, new char[]{')', '('});
        }else{
            ans.add(s);
        }
    }
}

public class RemoveInvalidParentheses{
    public static void main(String[] args) {
        List<String> ans = new Solution().removeInvalidParentheses(")(");
        System.out.println("ans");
        for(String s : ans){
            System.out.println(s);
        }
    }
}