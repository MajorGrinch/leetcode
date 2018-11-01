import java.util.Arrays;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        /*
        left[j] means the leftmost index of consecutive '1's starts
        from matrix[i][j] towards left.
        The same for right and height array
        */
        for(int i = 0; i < n; i++){
            left[i] = 0;
            right[i] = n;
            height[i] = 0;
        }
        // Arrays.fill(right, n);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int curr_left = 0, curr_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curr_left);
                } else {
                    left[j] = 0;
                    curr_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curr_right);
                } else {
                    right[j] = n;
                    curr_right = j;
                }
            }
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, (right[j] - left[j])*height[j]);
            }
        }
        return ans;
    }
}