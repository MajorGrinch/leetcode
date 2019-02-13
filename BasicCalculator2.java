import java.util.Stack;

class Solution {
    public int calculate(String s) {
        s = s.trim() ;
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int currNum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // System.out.println("current c : " + c);
            if(c == ' ') continue;
            if(c >= '0' && c <= '9'){
                currNum = currNum * 10 + c - '0';
            }else{
                if(c == '('){
                    operatorStack.push(c);
                    continue;
                }
                if(s.charAt(i-1) != ')'){
                    // if no ) on the left, there must be a num needed to be push
                    operandStack.push(currNum);
                    currNum = 0;
                }
                if(c == ')'){
                    while(!operatorStack.isEmpty()){
                        char op = operatorStack.pop();
                        if(op == '(') break;
                        else{
                            int num2 = operandStack.pop();
                            int num1 = operandStack.pop();
                            char nxtOp = operatorStack.isEmpty() ? ' ' : operatorStack.peek();
                            if(nxtOp == '-'){
                                if(op == '+') op = '-';
                                else if(op == '-') op = '+';
                            }
                            operandStack.push(cal(num1, num2, op));
                        }
                    }
                    continue;
                }
                if(!operatorStack.isEmpty() && getPri(c) <= getPri(operatorStack.peek())){
                    int num2 = operandStack.pop();
                    int num1 = operandStack.pop();
                    char op = operatorStack.pop();
                    char nxtOp = operatorStack.isEmpty() ? ' ' : operatorStack.peek();
                    if(nxtOp == '-'){
                        if(op == '+') op = '-';
                        else if(op == '-') op = '+';
                    }
                    operandStack.push(cal(num1, num2, op));
                }
                operatorStack.push(c);
            }
            // printStack(operandStack, operatorStack);

        }
        if(s.charAt(s.length()-1) != ')') operandStack.push(currNum);
        // printStack(operandStack, operatorStack);
        while(!operatorStack.isEmpty()){
            int num2 = operandStack.pop();
            int num1 = operandStack.pop();
            char op = operatorStack.pop();
            char nxtOp = operatorStack.isEmpty() ? ' ' : operatorStack.peek();
            if(nxtOp == '-'){
                if(op == '+') op = '-';
                else if(op == '-') op = '+';
            }
            operandStack.push(cal(num1, num2, op));
        }
        return operandStack.peek();
    }

    private void printStack(Stack<Integer> operandStack, Stack<Character> operatorStack){
        for(int num : operandStack){
            System.out.printf("%d ", num);
        }
        System.out.println();
        for(char op : operatorStack){
            System.out.printf("%c ", op);
        }
        System.out.println();
    }

    private int cal(int num1, int num2, char op){
        int res = 0;
        switch(op){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        return res;
    }

    /**
     * get the priority of operator c
     */
    private int getPri(char c){
        int pri = 0;
        switch(c){
            case '+':
            case '-':
                pri = 1;
                break;
            case '*':
            case '/':
                pri = 2;
                break;
            case '(':
                pri = 0;
                break;
        }
        return pri;
    }
}

public class BasicCalculator2{
    public static void main(String[] args) {
        // String input = "((3+2)*2+5 * (10-7))*5 +(3+9)*(1+1)";
        String input = "282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024";
        System.out.println(new Solution().calculate(input));
    }
}