
import java.util.*;
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        RevTrie revt =  new RevTrie();
        for(int i = 0; i < words.length; i++){
            revt.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++){
            // revt.search(words, i, ans);
            revt.search2(words, i, ans);
        }
        return ans;
    }

}

class RevTrie{
    private static int R = 26;
    private TrieNode root;
    private static class TrieNode{
        private int idx = -1;
        private TrieNode[] next = new TrieNode[R];
        private List<Integer> subPalin = new ArrayList<>();
    }

    public RevTrie(){
        root = new TrieNode();
    }
    private TrieNode put(TrieNode x, String key, int val, int d){
        if(x == null) x = new TrieNode();
        if(d == -1){
            x.idx = val;
            x.subPalin.add(val);
            return x;
        }
        if(isPalindrome(key, 0, d)){
            x.subPalin.add(val);
        }
        int c = key.charAt(d) - 'a';
        x.next[c] = put(x.next[c], key, val, d-1);
        return x;
    }

    public void search(String[] words, int idx, List<List<Integer>> ans){
        TrieNode x = root;
        String word = words[idx];
        for(int i = 0; i < word.length(); i++){
            if(x.idx != -1 && x.idx != idx && isPalindrome(word, i, word.length()-1)){
                ans.add(Arrays.asList(idx, x.idx));
            }
            x = x.next[word.charAt(i) - 'a'];
            if(x == null) return;
        }
        for(int i : x.subPalin){
            if(i != idx){
                ans.add(Arrays.asList(idx, i));
            }
        }
    }

    private void search2(TrieNode x, String[] words, int idx, List<List<Integer>> ans, int d){
        if(x == null) return;
        if(d == words[idx].length()){
            for(int i : x.subPalin){
                if(i == idx) continue;
                ans.add(Arrays.asList(idx, i));
            }
            return;
        }
        if(x.idx != -1 && x.idx != idx && isPalindrome(words[idx], d, words[idx].length()-1)){
            ans.add(Arrays.asList(idx, x.idx));
        }
        int c = words[idx].charAt(d) - 'a';
        search2(x.next[c], words, idx, ans, d+1);
    }

    public void search2(String[] words, int idx, List<List<Integer>> ans){
        search2(root, words, idx, ans, 0);
    }

    public void put(String key, int val){
        put(root, key, val, key.length()-1);
    }

    private boolean isPalindrome(String word, int i, int j){
        while(i < j){
            if(word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
}