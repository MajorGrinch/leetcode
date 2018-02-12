class Solution {
    class UnionFind{
        int[] s;
        int grid2Id(int row, int col, int cols){
            return row * cols + col;
        }
        UnionFind(int rows, int cols){
            s = new int[rows*cols];
            Arrays.fill(s, -1);
        }
        int find(int x){
            if(s[x] < 0){
                return x;
            }
            return s[x] = find(s[x]);
        }
        void union(int a, int b){
            int fa_a = find(a);
            int fa_b = find(b);
            if(s[fa_a] < s[fa_b]){
                s[fa_a] += s[fa_b];
                s[fa_b] = fa_a;
            }else{
                s[fa_b] += s[fa_a];
                s[fa_a] = fa_b;
            }
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if(positions.length == 0){
            return ans;
        }
        int count = 0;
        int map[][] = new int[m][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        UnionFind uf = new UnionFind(m, n);
        for(int[] coordiate : positions){
            int x = coordiate[0];
            int y = coordiate[1];
            if(map[x][y] != 1){
                map[x][y] = 1;
                count++;
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < m && ny >=0 && ny < n && map[nx][ny] == 1){
                        int fa_current = uf.find(uf.grid2Id(x, y, n));
                        int fa_nxt = uf.find(uf.grid2Id(nx, ny, n));
                        if(fa_current != fa_nxt){
                            uf.union(fa_current, fa_nxt);
                            count--;
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}