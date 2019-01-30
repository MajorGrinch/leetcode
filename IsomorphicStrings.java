class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] cnt1 = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(cnt1[sc[i]] == 0){
                cnt1[sc[i]] = tc[i];
            }else{
                if(cnt1[sc[i]] != tc[i]) return false;
            }
        }
        int[] cnt2 = new int[256];
        for(int i = 0; i < t.length(); i++){
            if(cnt2[tc[i]] == 0){
                cnt2[tc[i]] = sc[i];
            }else{
                if(cnt2[tc[i]] != sc[i]) return false;
            }
        }
        return true;
    }
}