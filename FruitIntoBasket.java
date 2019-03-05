import java.util.*;

class Solution {
    public int totalFruit(int[] tree) {
        final int maxTypes = 2;
        int numTypes = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int i = 0;
        int ans = 0;
        for(int j = 0; j < tree.length; j++){
            int cntj = cntMap.getOrDefault(tree[j], 0);
            if(cntj == 0){
                numTypes++;
            }
            cntMap.put(tree[j], cntj+1);
            while(numTypes > maxTypes){
                int cnti = cntMap.get(tree[i]);
                cntMap.put(tree[i], cnti-1);
                if(cnti-1 == 0) numTypes--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }
}