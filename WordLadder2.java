import java.util.*;

/**
 * BFS version 1
 */
class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> worddict) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(worddict);
        if (!dict.contains(end)) {
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
                            costs.put(child, steps + 1);
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

/**
 * BFS version 2
 */
class Solution2 {
    public List<List<String>> findLadders(String start, String end, List<String> worddict) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(worddict);
        if (!dict.contains(end)) {
            return ans;
        }
        dict.remove(start);
        dict.remove(end);
        HashSet<String> curr_level = new HashSet<>();
        HashSet<String> next_level = new HashSet<>();
        HashMap<String, HashSet<String>> childrenMap = new HashMap<>();
        int wordL = start.length();
        boolean found = false;
        curr_level.add(start);
        while (!curr_level.isEmpty() && !found) {
            dict.removeAll(curr_level);
            for (String curr_str : curr_level) {
                char[] sc = curr_str.toCharArray();
                childrenMap.put(curr_str, new HashSet<String>());
                for (int i = 0; i < wordL; i++) {
                    char ch = sc[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch)
                            continue;
                        sc[i] = c;
                        String child = new String(sc);
                        if (child.equals(end)) {
                            childrenMap.get(curr_str).add(end);
                            found = true;
                        } else if (dict.contains(child) && !found) {
                            next_level.add(child);
                            childrenMap.get(curr_str).add(child);
                        }
                    }
                    sc[i] = ch;
                }
            }
            curr_level.clear();
            HashSet<String> temp = curr_level;
            curr_level = next_level;
            next_level = temp;
        }
        for (String key : childrenMap.keySet()) {
            System.err.println(key + ": " + childrenMap.get(key));
        }
        if (found) {
            LinkedList<String> path = new LinkedList<>();
            path.add(start);
            getPath(start, end, childrenMap, path, ans);
        }
        return ans;
    }

    public static void getPath(String curr, String end, HashMap<String, HashSet<String>> childrenMap,
            LinkedList<String> path, List<List<String>> ans) {
        if (curr == end) {
            ans.add(new ArrayList<String>(path));
            return;
        }
        if (!childrenMap.containsKey(curr)) {
            return;
        }
        for (String str : childrenMap.get(curr)) {
            path.add(str);
            getPath(str, end, childrenMap, path, ans);
            path.removeLast();
        }
    }
}

/**
 * Bidirectional BFS
 */
class Solution3 {
    public List<List<String>> findLadders(String start, String end, List<String> worddict) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(worddict);
        if (!dict.contains(end)) {
            return ans;
        }
        dict.remove(start);
        dict.remove(end);
        HashSet<String> qf = new HashSet<>();
        HashSet<String> qb = new HashSet<>();
        qf.add(start);
        qb.add(end);
        HashMap<String, HashSet<String>> childrenMap = new HashMap<>();
        int wordL = start.length();
        boolean found = false;
        boolean backward = false;
        while( !qf.isEmpty() && !qb.isEmpty() && !found){
            if(qf.size() > qb.size()){
                HashSet<String> temp = qf;
                qf = qb;
                qb = temp;
                backward = !backward;
            }
            dict.removeAll(qf);
            dict.removeAll(qb);
            HashSet<String> qt = new HashSet<>();
            for(String curr_str : qf){
                // childrenMap.putIfAbsent(curr_str, new HashSet<>());
                char[] sc = curr_str.toCharArray();
                for(int i = 0; i < wordL; i++){
                    char ch = sc[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == ch) continue;
                        sc[i] = c;
                        String gen_word = new String(sc);
                        String child = gen_word;
                        String parent = curr_str;
                        if(backward){
                            String temp = parent;
                            parent = child;
                            child = temp;
                        }
                        if(qb.contains(gen_word)){
                            found = true;
                            childrenMap.putIfAbsent(parent, new HashSet<String>());
                            childrenMap.get(parent).add(child);
                        }else if(dict.contains(gen_word) && !found){
                            qt.add(gen_word);
                            childrenMap.putIfAbsent(parent, new HashSet<String>());
                            childrenMap.get(parent).add(child);
                        }
                    }
                    sc[i] = ch;
                }
            }
            qf = qt;
        }
        for (String key : childrenMap.keySet()) {
            System.err.println(key + ": " + childrenMap.get(key));
        }
        if(found){
            LinkedList<String> path = new LinkedList<>();
            path.add(start);
            getPath(start, end, childrenMap, path, ans);            
        }
        return ans;
    }
    void getPath(String curr, String end, HashMap<String, HashSet<String>> childrenMap,
            LinkedList<String> path, List<List<String>> ans) {
        if (curr.equals(end)) {
            ans.add(new ArrayList<String>(path));
            return;
        }
        if (!childrenMap.containsKey(curr)) {
            return;
        }
        for (String str : childrenMap.get(curr)) {
            path.add(str);
            getPath(str, end, childrenMap, path, ans);
            path.removeLast();
        }
    }
}

public class WordLadder2 {
    public static void main(String[] args) {
        // String[] input_array = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };
        String[] input_array = { "a", "b", "c", "d"};
        Solution3 solution = new Solution3();
        List<List<String>> ans = solution.findLadders("a", "c", Arrays.asList(input_array));
        for (List<String> l : ans) {
            System.err.println(l);
        }
    }
}