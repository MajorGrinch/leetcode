import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        for(int i = 1; i < len - 1; i++){
            int maxl = 0, maxr = 0;
            for(int j = i; j >= 0; j--){
                maxl = Math.max(maxl, height[j]);
            }
            for(int j = i; j < len; j++){
                maxr = Math.max(maxr, height[j]);
            }
            ans += Math.min(maxl, maxr) - height[i];
        }
        return ans;
    }
}

class Solution2{
    public int trap(int[] height){
        int ans = 0;
        int len = height.length;
        int[] maxl = new int[len];
        int[] maxr = new int[len];
        maxl[0] = height[0];
        maxr[len-1] = height[len-1];
        for(int i = 1; i < len; i++){
            maxl[i] = Math.max(maxl[i-1], height[i]);
        }
        for(int i = len - 2; i >= 0; i--){
            maxr[i] = Math.max(maxr[i+1], height[i]);
        }
        for(int i = 1; i <= len - 2; i++){
            ans += Math.min(maxl[i], maxr[i]) - height[i];
        }
        return ans;
    }
}

class Solution3{
    public int trap(int[] height){
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        while(curr < height.length){
            while(!st.isEmpty() && height[st.peek()] < height[curr]){
                int top = st.pop();
                if(st.isEmpty()) break;
                int dist = curr - st.peek() - 1;
                int minheight = Math.min(height[curr], height[st.peek()]) - height[top];
                ans += dist * minheight;
            }
            st.push(curr++);
        }
        return ans;
    }
}

class Solution4{
    public int trap(int[] height){
        if(height == null || height.length < 3) return 0;
        int ans = 0;
        int l = 0, r = height.length-1;
        int lmax = 0, rmax = 0;
        while(l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if(lmax < rmax){
                ans += lmax - height[l];
                l++;
            }else{
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }
}