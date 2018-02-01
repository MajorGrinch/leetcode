class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        for(String token : tokens){
            if(token.length() == 1 && !Character.isDigit(token.charAt(0))){
                char tmp = token.charAt(0);
                int a = stack.pop();
                int b = stack.pop();
                if(tmp == '+'){
                    stack.push(b+a);
                }
                if(tmp == '-'){
                    stack.push(b-a);
                }
                if(tmp == '*'){
                    stack.push(b*a);
                }
                if(tmp == '/'){
                    stack.push(b/a);
                }
            }else{
                int v = Integer.parseInt(token);
                stack.push(v);
            }
        }
        return stack.pop();
    }
}