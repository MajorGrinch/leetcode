class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            return addBinary(b, a);
        }
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        int[] ans = new int[a.length()];
        for(int i = a.length()-1, j = b.length()-1; i>=0 || j>=0; i--, j--){
            int sum = 0;
            sum += (i>=0) ? num1[i] - '0' : 0;
            sum += (j>=0) ? num2[j] - '0' : 0;
            ans[i] = sum;
        }
        for(int i = a.length()-1; i > 0; i--){
            ans[i-1] += ans[i] / 2;
            ans[i] %= 2;
        }
        StringBuilder sb = new StringBuilder();
        if(ans[0] / 2 == 1){
            sb.append("1");
            sb.append(ans[0]%2);
        }else{
            sb.append(ans[0]);
        }
        for(int i = 1; i < a.length(); i++){
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}