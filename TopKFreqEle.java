import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqmap = new HashMap<>();
        List<Integer>[] buck = new List[nums.length+1];
        for(int num: nums){
            freqmap.put(num, freqmap.getOrDefault(num, 0)+1);
        }
        for(int key: freqmap.keySet()){
            int freq = freqmap.get(key);
            if(buck[freq] == null){
                buck[freq] = new ArrayList<>();
            }
            buck[freq].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = buck.length-1; i >= 1 && k > 0; i--){
            if(buck[i] != null){
                for(int num: buck[i]){
                    ans.add(num);
                    k--;
                    if(k < 1) break;
                }
            }
        }
        return ans;
    }
}