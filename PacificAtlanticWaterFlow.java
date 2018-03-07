import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.*;

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return ans;
        }
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] pacificmap = new int[m][n];
        int[][] atlanticmap = new int[m][n];
        for (int i = 0; i < m; i++) {
            pacificmap[i][0] = 1;
            bfs(i, 0, vis, matrix, pacificmap);
        }
        for (int j = 0; j < n; j++) {
            pacificmap[0][j] = 1;
            bfs(0, j, vis, matrix, pacificmap);
        }

        for (int i = 0; i < m; i++)
            Arrays.fill(vis[i], false);

        for (int i = 0; i < m; i++) {
            atlanticmap[i][n-1] = 1;
            bfs(i, n - 1, vis, matrix, atlanticmap);
        }
        for (int j = 0; j < n; j++) {
            atlanticmap[m-1][j] = 1;
            bfs(m - 1, j, vis, matrix, atlanticmap);
        }
        // for(int i = 0; i < m; i++){
        //     System.out.println(Arrays.toString(pacificmap[i]));
        // }
        // System.out.println("-------------------");
        // for(int i = 0; i < m; i++){
        //     System.out.println(Arrays.toString(atlanticmap[i]));
        // }
        int[] point = new int[2];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (pacificmap[i][j] == 1 && atlanticmap[i][j] == 1) {
                    point[0] = i;
                    point[1] = j;
                    ans.add(Arrays.copyOf(point, 2));
                }
            }
        return ans;
    }

    void bfs(int x, int y, boolean[][] vis, int[][] map, int[][] cmap) {
        int[] dx = { 1, 0, 0, -1 };
        int[] dy = { 0, 1, -1, 0 };
        int m = map.length;
        int n = map[0].length;
        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();
        qx.offer(x);
        qy.offer(y);
        vis[x][y] = true;
        while (!qx.isEmpty()) {
            int curr_x = qx.poll();
            int curr_y = qy.poll();
            int curr_height = map[curr_x][curr_y];
            // System.out.println("x: " + curr_x + " y: " + curr_y);
            for (int i = 0; i < 4; i++) {
                int nxt_x = curr_x + dx[i];
                int nxt_y = curr_y + dy[i];
                if (nxt_x >= 0 && nxt_x < m && nxt_y >= 0 && nxt_y < n && !vis[nxt_x][nxt_y]
                        && curr_height <= map[nxt_x][nxt_y]) {
                    cmap[nxt_x][nxt_y] = 1;
                    qx.offer(nxt_x);
                    qy.offer(nxt_y);
                    vis[nxt_x][nxt_y] = true;
                }
            }
        }
    }
}

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] map = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };
        List<int[]> ans = new Solution().pacificAtlantic(map);
        for (int[] item : ans) {
            System.out.println("item: " + item[0] + " " + item[1]);
        }
    }
}