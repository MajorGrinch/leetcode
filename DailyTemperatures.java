import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T.length == 0) return new int[0];
        int[] ans = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}