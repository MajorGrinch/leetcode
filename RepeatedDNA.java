class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        List<String> ans = new ArrayList<String>();
        int len = s.length();
        for(int i = 0; i <= len - 10; i++ ){
            count.put(s.substring(i, i+10), count.getOrDefault(s.substring(i, i+10), 0)+1);
        }
        for(int i = 0; i <= len - 10; i++){
            if(count.getOrDefault(s.substring(i, i+10), 0) > 1){
                ans.add(s.substring(i, i+10));
                count.remove(s.substring(i, i+10));
            }
        }
        return ans;
    }
}