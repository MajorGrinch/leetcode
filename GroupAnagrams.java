class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<>();
        for(String str : strs){
            char[] sc = str.toCharArray();
            Arrays.sort(sc);
            String tmp = String.valueOf(sc);
            hmap.putIfAbsent(tmp, new ArrayList<>());
            hmap.get(tmp).add(str);
        }
        return new ArrayList<>(hmap.values());
    }
}