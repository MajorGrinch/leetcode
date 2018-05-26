public class ReverseWordsInAString2{
    public static void main(String[] args) {
        char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        new Solution().reverseWords(str);
        System.out.println(str);
    }
}

class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length);
        for(int i = 0, j = 0; j <= str.length; j++){
            if(j == str.length || str[j] == ' '){
                reverse(str, i, j);
                i = j + 1;
            }
        }
    }

    private void reverse(char[] str, int st, int ed){
        for(int i = 0; i < (ed-st)/2; i++){
            char tmp = str[st+i];
            str[st+i] = str[ed-i-1];
            str[ed-i-1] = tmp;
        }
    }
}