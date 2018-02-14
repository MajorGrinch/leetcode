class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 1 && num1.charAt(0) == '0'){
            return "0";
        }
        if(num2.length() == 1 && num2.charAt(0) == '0'){
            return "0";
        }
        
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] ans = new int[num1.length()+num2.length()];
        for(int i = n1.length-1; i >= 0; i--){
            for(int j = n2.length-1; j >= 0; j--){
                ans[i+j+1] += (n1[i]-'0') * (n2[j]-'0');
            }
        }
        for(int i = ans.length-1; i > 0; i--){
            ans[i-1] += ans[i] / 10;
            ans[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        if(ans[0] != 0){
            sb.append(ans[0]);
        }
        for(int i = 1; i < ans.length; i++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}