class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        int len = s.length();
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        for(int i = 0; i < len; i++){
            cntS[s.charAt(i)]++;
            cntT[t.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++){
            if(cntS[i] != cntT[i]){
                return false;
            }
        }
        return true;
    }
}