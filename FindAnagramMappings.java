import java.util.*;
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            if(!idxMap.containsKey(B[i]))
                idxMap.put(B[i], new ArrayList<Integer>());
            idxMap.get(B[i]).add(i);
        }
        int[] mapping = new int[A.length];
        for(int i = 0; i < A.length; i++){
            mapping[i] = idxMap.get(A[i]).get(0);
            idxMap.get(A[i]).remove(0);
        }
        return mapping;
    }
}

class Solution2 {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            idxMap.put(B[i], i);
        }
        int[] mapping = new int[A.length];
        for(int i = 0; i < A.length; i++){
            mapping[i] = idxMap.get(A[i]);
        }
        return mapping;
    }
}