class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        if(len % 2 == 1 || len == 0){
            return false;
        }
        stack.push(s.charAt(0));
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }
            if(s.charAt(i) == '}'){
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
            if(s.charAt(i) == ']'){
                if(stack.empty()){
                    return false;
                }
                if(stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }
            if(!stack.empty() && i == len-1){
                return false;
            }
        }
        return true;   
    }
}