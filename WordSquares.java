import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> hmap = new HashMap<>();
    List<String> squares = new ArrayList<>();
    
    void initHmap(String[] words){
        for(String word : words){
            hmap.putIfAbsent("", new ArrayList<>());
            hmap.get("").add(word);
            String prefix = "";
            for(char c : word.toCharArray()){
                prefix += c;
                hmap.putIfAbsent(prefix, new ArrayList<>());
                hmap.get(prefix).add(word);
            }
        }
    }
    
    boolean checkPrefix(String nxt_word, int d, int maxD){
        for(int i = d + 1; i < maxD; i++){
            String prefix = "";
            for(int k = 0; k < d; k++){
                prefix += squares.get(k).charAt(i);
            }
            prefix += nxt_word.charAt(i);
            if(!hmap.containsKey(prefix)){
                return false;
            }
        }
        return true;
    }
    
    void dfs(int d, int maxD){
        if(d == maxD){
            ans.add(new ArrayList(squares));
            return;
        }
        String prefix = "";
        for(int i = 0; i < d; i++){
            prefix += squares.get(i).charAt(d);
        }
        List<String> candidates = hmap.get(prefix);
        for(String candidate : candidates){
            if(!checkPrefix(candidate,  d, maxD)){
                continue;
            }
            squares.add(candidate);
            dfs(d+1, maxD);
            squares.remove(squares.size()-1);
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        if(words.length == 0){
            return ans;
        }
        int maxD = words[0].length();
        initHmap(words);
        dfs(0, maxD);
        return ans;
    }
}

class Solution2{
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> hmap = new HashMap<>();
    List<String> square = new ArrayList<>();

    private void initHmap(String[] words){
        hmap.put("", new ArrayList<>());
        for(String word : words){
            hmap.get("").add(word);
            String prefix = "";
            for(char c : word.toCharArray()){
                prefix += c;
                hmap.putIfAbsent(prefix, new ArrayList<>());
                hmap.get(prefix).add(word);
            }
        }
    }

    private boolean checkPrefix(String nxt_word, int d, int maxD){
        for(int i = d + 1; i < maxD; i++){
            String prefix = "";
            for(int k = 0; k < d; k++) prefix += square.get(k).charAt(i);
            prefix += nxt_word.charAt(i);
            if(!hmap.containsKey(prefix)) return false;
        }
        return true;
    }

    private void dfs(int d, int maxD){
        if(d == maxD){
            ans.add(new ArrayList<>(square));
            return;
        }
        String prefix = "";
        for(int i = 0; i < d; i++)
            prefix += square.get(i).charAt(d);
        List<String> candidates = hmap.get(prefix);
        for(String candidate : candidates){
            if(!checkPrefix(candidate, d, maxD)) continue;
            square.add(candidate);
            dfs(d+1, maxD);
            square.remove(d);
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        if(words.length == 0) return ans;
        int maxD = words[0].length();
        initHmap(words);
        dfs(0, maxD);
        return ans;
    }
}