public class ReverseWordsInAString{
    public static void main(String[] args) {
        String input = "the sky is blue";
        System.out.println(new Solution().reverseWords(input));
    }
}
class Solution {
    public String reverseWords(String s) {
        StringBuilder revwords = new StringBuilder();
        int j = s.length();
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                j = i;
            }else if(i == 0 || s.charAt(i-1) == ' '){
                if(revwords.length() != 0){
                    revwords.append(' ');
                }
                revwords.append(s.substring(i, j));
            }
        }
        return revwords.toString();
    }
}