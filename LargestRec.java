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

class Solution2{
    /*
    left[i] stores the nearest element, which on the left of i, that is lower than i
    right[i] stores the nearest element, which on the right of i, that is lower than i
     */
    public int largestRectangleArea(int[] heights){
        if(heights.length == 0) return 0;
        int[] left = new int[heights.length];
        left[0] = -1;
        for(int i = 1; i < heights.length; i++){
            int l = i - 1;
            while(l>=0 && heights[l]>=heights[i]){
                l = left[l];
            }
            left[i] = l;
        }
        int[] right = new int[heights.length];
        right[heights.length-1] = heights.length;
        for(int i = heights.length-2; i >= 0; i--){
            int r = i + 1;
            while(r <= heights.length-1 && heights[r]>=heights[i]){
                r = right[r];
            }
            right[i] = r;
        }
        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            ans = Math.max(ans, (right[i]-left[i]-1) * heights[i]);
        }
        return ans;
    }
}