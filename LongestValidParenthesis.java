import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int ans = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                }
                else if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + (i - dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}

class Solution2{
    public int longestValidParentheses(String s){
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                else ans = Math.max(ans, i - st.peek());
            }
        }
        return ans;
    }
}