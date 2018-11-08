import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numSquares(int n) {
        if(n < 0) return 0;
        Deque<Integer> squares = new ArrayDeque<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, 0);
        int sum;
        int bound = (int)Math.sqrt(n) + 1;
        for(int i = 1; i <= bound; i++){
            sum = i * i;
            if(sum <= n){
                squares.offer(sum);
                visited[sum] = 1;
            }
        }
        if(visited[n] == 1){
            return 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int ele : squares){
            q.offer(ele);
            // System.out.println(ele);
        }
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(int num : squares){
                    int nextNum = curr + num;
                    // System.out.println("steps: " + steps + " nextNum: " + nextNum);
                    if(nextNum == n){
                        return steps;
                    }
                    else if(nextNum > n) break;
                    else if(visited[nextNum] == 0){
                        q.offer(nextNum);
                        visited[nextNum] = 1;
                    }
                }
            }

        }
        return 4;
    }
}

class Solution2{
    public int numSquares(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int minPrev = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0){
                minPrev = Math.min(dp[i-j*j], minPrev);
                j++;
            }
            dp[i] = minPrev + 1;
        }
        return dp[n];
    }
}

public class PerfectSquares{
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.numSquares(99));
    }
}