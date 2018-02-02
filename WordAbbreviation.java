class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int len = dict.size();
        int[] prefix = new int[len];
        String[] ans = new String[len];
        Map<String, Integer> hmap = new HashMap<>();
        for(int i = 0; i < len; i++){
            ans[i] = getAbbr(dict.get(i), 1);
            prefix[i] = 1;
            hmap.put(ans[i], hmap.getOrDefault(ans[i], 0)+1);
        }
        int k = 0;
        while( k <= 400 ){
            boolean unique = true;
            for(int i = 0; i < len; i++){
                if(hmap.get(ans[i]) > 1){
                    prefix[i]++;
                    ans[i] = getAbbr(dict.get(i), prefix[i]);
                    hmap.put(ans[i], hmap.getOrDefault(ans[i], 0)+1);
                    unique = false;
                }
            }
            if(unique){
                break;
            }
            k++;
        }
        return Arrays.asList(ans);
    }
    /*
    get the abbreviation for s with certain length of prefix
    */
    String getAbbr(String s, int prefix){
        if(s.length() - prefix <= 2){
            return s;
        }
        String res = s.substring(0, prefix) + (s.length() - prefix - 1) + s.charAt(s.length()-1);
        return res;
    }
}