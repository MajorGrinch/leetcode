import java.util.Arrays;
import java.util.*;

/**
 * BFS version 1
 */
class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> worddict) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(worddict);
        if(!dict.contains(end)){
            return ans;
        }
        dict.remove(start);
        dict.remove(end);
        HashMap<String, HashSet<String>> parents = new HashMap<>();
        HashMap<String, Integer> costs = new HashMap<>();
        Queue<String> qn = new ArrayDeque<>();
        qn.offer(start);
        costs.put(start, 1);
        parents.put(end, new HashSet<String>());
        int wordL = start.length();
        boolean found = false;
        int steps = 0;
        System.err.println("start while");
        while (!qn.isEmpty() && !found) {
            steps++;
            int size = qn.size();
            for (int i = 0; i < size; i++) {
                String curr_str = qn.poll();
                char[] sc = curr_str.toCharArray();
                for (int j = 0; j < wordL; j++) {
                    char ch = sc[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch)
                            continue;
                        sc[j] = c;
                        String child = new String(sc);
                        if (child.equals(end)) {
                            found = true;
                            parents.get(end).add(curr_str);
                        } else if (costs.containsKey(child) && costs.get(child) > steps) {
                            //already generated word but not the parent
                            parents.get(child).add(curr_str);
                        }
                        if (dict.contains(child)) {
                            qn.offer(child);
                            dict.remove(child);
                            costs.put(child, steps+1);
                            HashSet<String> parent = new HashSet<>();
                            parent.add(curr_str);
                            parents.put(child, parent);
                        }
                    }
                    sc[j] = ch;
                }
            }
        }
        if (found) {
            LinkedList<String> path = new LinkedList<>();
            path.add(end);
            getPath(end, start, parents, path, ans);
        }
        return ans;
    }
    void getPath(String curr, String end, HashMap<String, HashSet<String>> parents, LinkedList<String> path,
            List<List<String>> ans) {
        if (curr.equals(end)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (String str : parents.get(curr)) {
            path.addFirst(str);
            getPath(str, end, parents, path, ans);
            path.removeFirst();
        }
    }
}

public class WordLadder2 {
    public static void main(String[] args) {
        String[] input_array = {"ted","tex","red","tax","tad","den","rex","pee"};
        // String[] input_array = {"a", "b", "c"};
        Solution solution = new Solution();
        List<List<String>> ans = solution.findLadders("red", "tax", Arrays.asList(input_array));
        for(List<String> l : ans){
            System.err.println(l);
        }
    }
}