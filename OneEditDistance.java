class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()){
            return isOneEditDistance(t, s);
        }
        if(t.length() - s.length() > 1){
            return false;
        }
        int len = s.length();
        if(t.length() - s.length() == 1){
            for(int i = 0; i < len; i++){
                if(s.charAt(i) != t.charAt(i)){
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        if(t.length() - s.length() == 0){
            int nDiff = 0;
            for(int i = 0; i < len; i++){
                if(s.charAt(i) != t.charAt(i)){
                    nDiff++;
                }
            }
            return (nDiff == 1);
        }
        return true;
    }
}