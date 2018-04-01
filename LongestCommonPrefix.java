class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int minlen = Integer.MAX_VALUE;
        for(String str : strs)
            minlen = Math.min(minlen, str.length());
        for(int len = minlen; len > 0; len--){
            boolean common = true;
            String prestr = strs[0].substring(0, len);
            for(String str: strs){
                if(!str.startsWith(prestr))
                    common = false;
            }
            if(common){
                return prestr;
            }
        }
        return "";
    }
}
public class LongestCommonPrefix{
    public static void main(String[] args) {
        String[] strs = {"ABCD", "ABEF", "ABDE"}; 
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}