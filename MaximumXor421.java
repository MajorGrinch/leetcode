import java.util.*;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, ans = 0;
        for(int i = 31; i >= 0; i--){
            mask |= (1 << i);
            Set<Integer> prefixSet = new HashSet<>();
            for(int num : nums){
                prefixSet.add(num & mask);
            }
            int tmpAns = ans | (1<<i);
            for(int prefix : prefixSet){
                if(prefixSet.contains(tmpAns ^ prefix)){
                    ans = tmpAns;
                    break;
                }
            }
        }
        return ans;
    }
}

class Solution2{
    public int findMaximumXOR(int[] nums){
        TrieNode prefixTrie = new TrieNode();
        for(int num : nums){
            add(prefixTrie, num);
        }
        int ans = 0;
        for(int num : nums){
            int another = findPair(prefixTrie, num);
            ans = Math.max(ans, another ^ num);
        }
        return ans;
    }

    private void add(TrieNode root, int num){
        for(int i = 31; i >= 0; i--){
            int currBit = (num >> i) & 1;
            if(currBit == 0){
                if(root.left == null) root.left = new TrieNode();
                root = root.left;
            }else{
                if(root.right == null) root.right = new TrieNode();
                root = root.right;
            }
        }
    }

    private int findPair(TrieNode root, int num){
        int res = 0;
        for(int i = 31; i >= 0; i--){
            int currBit = (num >> i) & 1;
            if(currBit == 0){
                if(root.right != null){
                    root = root.right;
                    res += 1 << i;
                }else{
                    root = root.left;
                }
            }else{
                if(root.left != null) root = root.left;
                else{
                    root = root.right;
                    res += 1 << i;
                }
            }
        }
        return res;
    }
    class TrieNode{
        TrieNode left;
        TrieNode right;
    }
}