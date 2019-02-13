import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();
        s = s.trim() + " ";
        int i = 0;
        char[] sc = s.toCharArray();
        while(i < s.length()){
            char c = sc[i];
            if(Character.isDigit(c)){
                int j = i+1;
                while(j < s.length() && Character.isDigit(sc[j])){
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                if(!operatorStack.isEmpty() && operatorStack.peek() != '('){
                    char op = operatorStack.pop();
                    int num1 = operandStack.pop();
                    if(op == '+'){
                        operandStack.push(num1 + num);
                    }else{
                        operandStack.push(num1 - num);
                    }
                }else{
                    operandStack.push(num);
                }
                i = j-1;
            }else if(c == '+' || c == '-' || c == '('){
                operatorStack.push(c);
            }else if( c == ')'){
                // printStack(operandStack, operatorStack);
                operatorStack.pop();
                if(!operatorStack.isEmpty() && operatorStack.peek() != '('){
                    char op = operatorStack.pop();
                    int num2 = operandStack.pop();
                    int num1 = operandStack.pop();
                    if(op == '+'){
                        operandStack.push(num1+num2);
                    }else{
                        operandStack.push(num1 - num2);
                    }
                }
            }
            i++;
        }
        
        return operandStack.peek();
        
    }
}

class Solution2{
    public int calculate(String s){
        return recurCal(0, s)[1];
    }

    private int[] recurCal(int start, String s){
        int result = 0;
        int num = 0;
        boolean isPlus = true;
        for(int i = start; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }else if(c == '+' || c == '-'){
                result = isPlus ? result + num : result - num;
                num = 0;
                isPlus = (c == '+');
            }else if(c == '('){
                int[] ret = recurCal(i+1, s);
                i = ret[0];
                result = isPlus ? result + ret[1] : result - ret[1];
            }else if(c == ')'){
                result = isPlus ? result + num : result - num;
                return new int[]{i, result};
            }
        }
        result = isPlus ? result + num : result - num;
        return new int[]{s.length(), result};
    }
}

public class BasicCalculator{
    public static void main(String[] args) {
        String input = " 2-1 + 2 ";
        // String input = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new Solution().calculate(input));
    }
}