class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()){
            return addStrings(num2, num1);
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] ans = new int[num1.length()];
        for(int i = num1.length()-1, j = num2.length()-1; i>=0 || j>=0; i--, j--){
            int sum = 0;
            sum += (i>=0) ? n1[i] - '0' : 0;
            sum += (j>=0) ? n2[j] - '0' : 0;
            ans[i] = sum;
        }
        for(int i = num1.length()-1; i > 0; i--){
            ans[i-1] += ans[i] / 10;
            ans[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num1.length(); i++){
            sb.append(Integer.toString(ans[i]));
        }
        return sb.toString();
    }
}