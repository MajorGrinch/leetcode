import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            while(st.peek() != -1 && heights[st.peek()] >= heights[i]){
                ans = Math.max(ans, heights[st.pop()] * (i - 1 - st.peek()) );
            }
            st.push(i);
        }
        while(st.peek() != -1){
            ans = Math.max(ans, heights[st.pop()] * (heights.length-1-st.peek()));
        }
        return ans;
    }
}