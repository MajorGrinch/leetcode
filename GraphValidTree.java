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

/**
 * BFS version
 */
class Solution {
    Map<Integer, Set<Integer>> createGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0){
            return true;
        }
        if(n-1 != edges.length){
            return false;
        }
        Map<Integer, Set<Integer>> ll_graph = createGraph(n, edges);
        Queue<Integer> qn = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        qn.offer(edges[0][0]);
        vis[edges[0][0]] = true;
        while(!qn.isEmpty()){
            int curr_n = qn.poll();
            for(int neighbour : ll_graph.get(curr_n)){
                if(!vis[neighbour]){
                    vis[neighbour] = true;
                    qn.offer(neighbour);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}