import java.util.Stack;

/**
 * tmp stores current string with []
 * and you can think the whole string is with a extra
 * super []
 * a [] contains the pattern [a-z]*[0-9]*[[a-z]+]
 * use a string stack to store all leading chars with a []
 * when encounter a ']', pop a string from string stack and append
 * repeated pattern to it as the tmp
 */
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] sc = s.toCharArray();
        Stack<Integer> kStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String tmp = "";
        strStack.push(tmp);
        int k = 0;
        int i = 0;
        while(i < sc.length){
            if(Character.isDigit(sc[i])){
                while(Character.isDigit(sc[i])){
                    k = 10 * k + sc[i] - '0';
                    i++;
                }
                kStack.push(k);
                k = 0;
            }else if(sc[i] == '['){
                strStack.push(tmp);
                tmp = "";
                i++;
            }else if(sc[i] == ']'){
                int times = kStack.pop();
                tmp = strStack.pop() + repeatStr(tmp, times);
                i++;
            }else{
                tmp += sc[i++];
            }
        }
        return tmp;
    }
    private String repeatStr(String str, int times){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++){
            sb.append(str);
        }
        return sb.toString();
    }
}

public class DecodeString{
    public static void main(String[] args) {
        Solution s =new Solution();
        // String input = "3[a]2[bc]";
        String input = "2[2[b]]";
        // String input = "3[a2[c]]";
        System.out.println(s.decodeString(input));
    }
}