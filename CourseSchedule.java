class Solution {
    class Vertex{
        int degree = 0;
        List<Integer> neighbours = new ArrayList<>();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(len == 0 || len == 1){
            return true;
        }
        // boolean[] vis = new boolean[numCourses];
        Vertex[] vertexs = new Vertex[numCourses];
        for(int i = 0; i < numCourses; i++){
            vertexs[i] = new Vertex();
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
            count++;
            if(curr.neighbours.size() != 0){
                for(int neighbour : curr.neighbours){
                    if(--vertexs[neighbour].degree == 0){
                        qv.offer(vertexs[neighbour]);
                    }
                }
            }
            
        }
        return count == numCourses;
    }

}