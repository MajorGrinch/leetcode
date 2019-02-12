import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] separator = new String[]{"", " Thousand", " Million", " Billion"};
    String[] ones = new String[]{"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
    String[] teens = new String[]{" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fiften", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    String[] tys =  new String[]{" Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

    public String numberToWords(int num) {
        StringBuilder ans = new StringBuilder();
        List<String> ansStrs = new ArrayList<>();
        while(num > 0){
            ansStrs.add(blockProcess(num % 1000));
            num /= 1000;
        }
        int sz = ansStrs.size();
        System.out.println("sz = " + sz);
        for(int i = sz - 1; i >= 0; i--){
            if(ansStrs.get(i).equals("")) continue;
            ans.append(ansStrs.get(i));
            ans.append(separator[i]);
        }
        return ans.toString().trim();
    }

    /**
     * process number from 0 - 999
     */
    private String blockProcess(int num){
        StringBuilder sb = new StringBuilder();
        int hundreds = num / 100;
        if(hundreds > 0){
            sb.append(ones[hundreds]);
            sb.append(" Hundred");
        }
        int tens = (num / 10) % 10;
        if(tens > 1){
            sb.append(tys[tens-2]);
        }
        if(tens == 1){
            int tmp = num - hundreds * 100;
            sb.append(teens[tmp - 10]);
            return sb.toString();
        }
        int units = num % 10;
        sb.append(ones[units]);
        return sb.toString();
    }
}

class Solution2{
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    private String blockProcess(int num){
        if(num == 0) return "";
        else if(num < 20) return LESS_THAN_20[num] + " ";
        else if(num < 100) return TENS[num/10] + " " +  blockProcess(num % 10);
        else return LESS_THAN_20[num/100] + " Hundred " + blockProcess(num % 100);
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String ans = "";
        int i = 0;
        while(num > 0){
            if(num % 1000 != 0){
                ans = blockProcess(num % 1000) + THOUSANDS[i] + " " + ans;
            }
            num /= 1000;
            i++;
        }
        return ans.trim();
    }
}

public class Integer2EngWords{
    public static void main(String[] args) {
        int num = 0;
        System.out.println(new Solution().numberToWords(num));
    }
}