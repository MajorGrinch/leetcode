class Solution {
    class Vertex{
        int val;
        int degree = 0;
        List<Integer> neighbours = new ArrayList<>();
        Vertex(int val){
            this.val = val;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] ans = new int[numCourses];
        Vertex[] vertexs = new Vertex[numCourses];
        for(int i = 0; i < numCourses; i++){
            vertexs[i] = new Vertex(i);
        }
        for(int i = 0; i < len; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            vertexs[v].neighbours.add(u);
            vertexs[u].degree++;
        }
        Queue<Vertex> qv = new ArrayDeque<>();
        for(int i = 0; i < vertexs.length; i++){
            if(vertexs[i].degree == 0){
                qv.add(vertexs[i]);
            }
        }
        int count = 0;
        while(!qv.isEmpty()){
            Vertex curr = qv.poll();
            ans[count] = curr.val;
            count++;
            if(curr.neighbours.size() != 0){
                for(int neighbour : curr.neighbours){
                    if(--vertexs[neighbour].degree == 0){
                        qv.offer(vertexs[neighbour]);
                    }
                }
            }
            
        }
        return (count == numCourses) ? ans : new int[0];
    }
}