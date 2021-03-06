/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * iterative version
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hmap = new HashMap<>();
        nodes.add(node);
        hmap.put(node, new UndirectedGraphNode(node.label));
        //find all the nodes and clone them to a new arraylist
        for(int i = 0; i < nodes.size(); i++){
            UndirectedGraphNode curr = nodes.get(i);
            for(UndirectedGraphNode neighbor : curr.neighbors){
                if(!hmap.containsKey(neighbor)){
                    nodes.add(neighbor);
                    hmap.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        System.err.println(nodes.size());
        
        //clone the neighbor from original graph to new graph
        for(int i = 0; i < nodes.size(); i++){
            UndirectedGraphNode curr = hmap.get(nodes.get(i));
            for(UndirectedGraphNode neighbor : nodes.get(i).neighbors){
                curr.neighbors.add(hmap.get(neighbor));
            }
        }
        return hmap.get(node);
    }
}

/**
 * DFS version
 */
public class Solution {
    HashMap<Integer, UndirectedGraphNode> vis = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node);
    }
    
    UndirectedGraphNode dfs(UndirectedGraphNode curr){
        if(curr == null){
            return null;
        }
        if(vis.containsKey(curr.label)){
            return vis.get(curr.label);
        }
        UndirectedGraphNode temp = new UndirectedGraphNode(curr.label);
        vis.put(curr.label, temp);
        for(UndirectedGraphNode neighbor : curr.neighbors){
            temp.neighbors.add(dfs(neighbor));
        }
        return temp;
    }
}