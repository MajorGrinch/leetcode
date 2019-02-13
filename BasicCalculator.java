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

    private void printStack(Stack<Integer> operandStack, Stack<Character> operatorStack){
        for(int num : operandStack){
            System.out.printf("%d ", num);
        }
        System.out.println();
        for(char c : operatorStack){
            System.out.printf("%c ", c);
        }
        System.out.println();
    }
}

public class BasicCalculator{
    public static void main(String[] args) {
        String input = " 2-1 + 2 ";
        // String input = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new Solution().calculate(input));
    }
}