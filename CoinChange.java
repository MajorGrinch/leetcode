import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        if(amount == 0) return 0;
        int minDeno = Integer.MAX_VALUE;
        for(int deno : coins){
            minDeno = Math.min(deno, minDeno);
        }
        if(amount < minDeno) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int deno: coins){
            if(deno <= amount) dp[deno] = 1;
        }
        for(int i = minDeno+1; i <= amount; i++){
            int res = Integer.MAX_VALUE;
            for(int deno : coins){
                if(i-deno >= 0 && dp[i-deno] != -1){
                    res = Math.min(dp[i-deno] + 1, res);
                }
            }
            dp[i] = (res == Integer.MAX_VALUE ? -1 : res) ;
        }
        return dp[amount];
    }
}
public class CoinChange{
    public static void main(String[] args) {
        int[] input = new int[]{186,419,83,408};
        System.out.println(new Solution().coinChange(input, 6249));
    }
}