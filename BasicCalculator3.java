import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> opDeque = new ArrayDeque<>();

        int l1 = 0, o1 = 1;
        int l2 = 1, o2 = 1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c >= '0' && c <= '9'){
                int num = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(++i) - '0';
                }
                l2 = (o2 == 1 ? l2*num : l2/num);
            }else if(c == '('){
                opDeque.offerFirst(l1);
                opDeque.offerFirst(o1);
                opDeque.offerFirst(l2);
                opDeque.offerFirst(o2);

                l1 = 0; o1 = 1;
                l2 = 1; o2 = 1;
            }else if(c == ')'){
                int num = l1 + o1 * l2;

                o2 = opDeque.poll();
                l2 = opDeque.poll();
                o1 = opDeque.poll();
                l1 = opDeque.poll();

                l2 =  (o2 == 1 ? l2*num : l2/num);
            }else if(c == '*' || c == '/'){
                o2 = (c=='*' ? 1 : -1);
            }else if(c == '+' || c == '-'){
                l1 += o1 * l2;
                o1 = (c == '+' ? 1 : -1);

                o2 = 1; l2 = 1;
            }
        }
        return l1 + o1 * l2;
    }
}

public class BasicCalculator3{
    public static void main(String[] args) {
        String input = "(2+6* 3+5- (3*14/7+2)*5)+3";
        System.out.println(new Solution().calculate(input));
    }
}