/**
 * Dijkstra version
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        int[][] map = new int[len+1][len+1];
        int[] cost = new int[len+1];
        boolean[] vis = new boolean[len+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for(int j = 0;  j< len; j++){
            if(hasRoad(beginWord, wordList.get(j))){
                map[0][j+1] = 1;
                map[j+1][0] = 1;
            }
        }
        int src = 0, dst = 0;
        for(int i = 0; i < len; i++){
            if(wordList.get(i).equals(endWord)){
                dst = i+1;
            }
        }
        if(dst == 0){
            return 0;
        }
        for(int i = 1; i < len; i++){
            for(int j = i+1; j <= len; j++){
                if(hasRoad(wordList.get(i-1), wordList.get(j-1))){
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
        vis[src] = true;
        //dijkstra
        for(int i = 1; i <= len; i++){
            if(map[0][i] == 1){
                cost[i] = 1;
            }
        }
        cost[src] = 0;
        // System.err.println(dst);
        for(int i = 1; i <= len; i++){
            int temp = Integer.MAX_VALUE;
            int u = i;
            for(int j = 1; j <= len; j++){
                if(!vis[j] && cost[j] < temp){
                    u = j;
                    temp = cost[j];
                }
            }
            vis[u] = true;
            for(int j = 1; j <= len; j++){
                if(!vis[j] && map[u][j] == 1){
                    int newDist = cost[u] + map[u][j];
                    if(newDist < cost[j]){
                        cost[j] = newDist;
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? 0 : cost[dst]+1;
    }
    boolean hasRoad(String str1, String str2){
        int len = str1.length();
        if(len == 0){
            return false;
        }
        int diff = 0;
        for(int i = 0; i < len; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diff++;
            }
        }
        return (diff == 1) ? true : false;
    }
    
}

/**
 * BFS version
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        if(!dict.contains(endWord)){
            return 0;
        }
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int wordL = beginWord.length();
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String s = q.poll();
                char[] sc = s.toCharArray();
                for(int j = 0; j < wordL; j++){
                    char ch = sc[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == ch) continue;
                        sc[j] = c;
                        String temp = new String(sc);
                        if(temp.equals(endWord)) return steps + 1;
                        if(!dict.contains(temp)) continue;
                        dict.remove(temp);
                        q.offer(temp);
                    }
                    sc[j] = ch;
                }
            }
        }
        return 0;
    }
}