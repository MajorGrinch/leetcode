class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i = 0; i < len; i++){
            if(count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}