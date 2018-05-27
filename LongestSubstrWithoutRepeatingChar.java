public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxL = 1, j = 0;
        if(len == 0 || len == 1){
            return len;
        }
        int[] count = new int[256];
        char[] sc = s.toCharArray();
        for(int i = 0; i < len; i++){
            while( j < len && count[sc[j]] == 0 ){
                count[sc[j]] = 1;
                j++;
            }
            maxL = Math.max(maxL, j-i);
            count[sc[i]] = 0;
        }
        return maxL;
    }
}