/**
 * Union Set version
 */
class Solution {
    class UnionFind{
        int[] s;
        UnionFind(int n){
            s = new int[n];
            Arrays.fill(s, -1);
        }
        int find(int x){
            if(s[x] < 0)
                return x;
            return s[x] = find(s[x]);
        }
        void union(int a, int b){
            int pt_a = find(a);
            int pt_b = find(b);
            if(s[pt_a] < s[pt_b]){
                s[pt_a] += s[pt_b];
                s[pt_b] = pt_a;
            }else{
                s[pt_b] += s[pt_a];
                s[pt_a] = pt_b;
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            if(uf.find(edges[i][0]) == uf.find(edges[i][1])){
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}