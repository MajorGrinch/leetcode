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
        ExpressionAddOperator eao = new ExpressionAddOperator();
        List<String> res = eao.addOperators("123", 6);

        for(String str : res){
            System.out.println(str);
        }
    }
}