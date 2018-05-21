public class ImplementStrStr{
    public static void main(String[] args) {
        String haystack = "aaaaab", needle = "ab";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length(), nl = needle.length();
        for(int i = 0; ; i++){
            int j = 0;
            for(j = 0; j < nl; j++){
                if(i + j == hl) return -1;
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
            }
            if(j == nl) return i;
        }
    }
}