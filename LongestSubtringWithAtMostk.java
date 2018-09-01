class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0, numDistinct = 0, maxL = 0;
        int[] count = new int[256];
        for(int j = 0; j < s.length(); j++){
            if(count[s.charAt(j)] == 0) numDistinct++;
            count[s.charAt(j)]++;
            while(numDistinct > k){
                count[s.charAt(i)]--;
                if(count[s.charAt(i)] == 0) numDistinct--;
                i++;
            }
            maxL = Math.max(maxL, j - i + 1);
        }
        return maxL;
    }
}