class Solution {
    public int maxArea(int[] height) {
       int marea = 0;
       int l = 0, r = height.length - 1;
       while(l < r){
            marea = Math.max(marea, Math.min(height[l], height[r])*(r-l));
            if(height[l] < height[r])
                l++;
            else
                r--;
    
       }
       return marea;
    }
}

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 3, 2 };
        System.out.println(new Solution().maxArea(height));
    }
}