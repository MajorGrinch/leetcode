class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> rounds = new Stack<>();
        for(String op : ops){
            if(op.equals("D")){
                rounds.push(rounds.peek()*2);
            }
            else if(op.equals("C")){
                rounds.pop();
            }
            else if(op.equals("+")){
                int last1 = rounds.pop();
                int last2 = rounds.pop();
                int curr = last1 + last2;

                /** mind the order when push back */
                rounds.push(last2);
                rounds.push(last1);
                rounds.push(curr);
            }
            else{
                rounds.push(Integer.parseInt(op));
            }
        }
        int ans = 0;
        while(!rounds.isEmpty()){
            ans += rounds.pop();
        }
        return ans;
    }
}