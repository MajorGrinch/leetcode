public class Solution {
    /*
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        int len = s.length(), maxL = 1, j = 0;
        if(len == 0 || len == 1){
            return len;
        }
        int[] count = new int[256];
        char[] sc = s.toCharArray();
        for(int i = 0; i < len; i++){
            while( j < len && count[sc[j]] == 0 ){
                count[sc[j]] = 1;
                maxL = Math.max(maxL, j-i+1);
                j++;
            }
            count[sc[i]] = 0;
        }
        return maxL;
    }
}