import java.util.LinkedList;
import java.util.Queue;

class Trie {

    private Node root;

    static class Node{
        private int val;
        private Node[] next = new Node[26];
        public Node(){
            //default val is -1 which means no key associate with this node
            val = -1;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word, 0);
    }

    private Node insert(Node n, String word, int d){
        if(n == null){
            n = new Node();
        }
        if(d == word.length()){
            n.val = 1;
            return n;
        }
        char c = word.charAt(d);
        int idx = c - 'a';
        n.next[idx] = insert(n.next[idx], word, d+1);
        return n;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node ans = search(root, word, 0);
        return ans != null && ans.val != -1;
    }

    private Node search(Node n, String word, int d){
        if(n == null) return null;
        if(d == word.length()) return n;
        char c = word.charAt(d);
        int idx = c - 'a';
        return search(n.next[idx], word, d+1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node start = search(root, prefix, 0);
        return start != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */