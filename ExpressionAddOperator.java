import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionAddOperator {
    /*
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    String num_str;
    int target_num;
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        // write your code here
        target_num = target;
        num_str = num;
        dfs("", 0, 0, 0);
        return ans;
    }
    void dfs(String current_exp, int position, long sum, long lastFactor){
        if(position == num_str.length() && sum == target_num){
            ans.add(current_exp);
            return;
        }
        for(int i = position+1; i <= num_str.length(); i++){
            long current_num = Long.parseLong(num_str.substring(position, i));
            if(position == 0){
                dfs(""+current_num, i, current_num, current_num);
            }else{
                dfs(current_exp + "*" + current_num, i, sum+(current_num-1)*lastFactor, lastFactor*current_num);
                dfs(current_exp + "+" + current_num, i, sum+current_num, current_num);
                dfs(current_exp + "-" + current_num, i, sum-current_num, -current_num);
            }
            if(num_str.charAt(position) == '0'){
                break;
            }
        }
    }
    public static void main(String[] args) {
        // ExpressionAddOperator eao = new ExpressionAddOperator();

        List<String> res = new Solution().addOperators("12345", 120);

        for(String str : res){
            System.out.println(str);
        }
    }
}

class Solution {
    private int target_num;
    private char[] num_arr;
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if(num.length() == 0) return ans;
        target_num = target;
        num_arr = num.toCharArray();
        char[] exp = new char[num_arr.length * 2 - 1];
        long n = 0;
        for(int i = 0; i < num_arr.length; i++){
            exp[i] = num_arr[i];
            n = n*10 + num_arr[i] - '0';
            search(exp, i+1, i+1, n, n);
            if(n == 0) break;
        }
        return ans;
    }
    /**
     * 
     * @param exp   expression array
     * @param numi  current index of num array
     * @param expi  current index of expression array
     * @param sum   current product of exp
     * @param lastFactor    last product of *
     */
    private void search(char[] exp, int numi, int expi, long sum, long lastFactor){
        if(numi == num_arr.length && sum == target_num){
            ans.add(new String(exp, 0, expi));
            return;
        }
        long curr_num = 0;
        int opi = expi;
        expi++;
        for(int i = numi; i < num_arr.length; i++){
            curr_num = curr_num * 10 + num_arr[i] - '0';
            exp[expi++] = num_arr[i];
            exp[opi] = '+';
            search(exp, i + 1, expi, sum + curr_num, curr_num);
            exp[opi] = '-';
            search(exp, i + 1, expi, sum -curr_num, -curr_num);
            exp[opi] = '*';
            search(exp, i + 1, expi, sum + (curr_num-1)*lastFactor, curr_num*lastFactor );
            if(curr_num == 0) break;
        }
    }
}