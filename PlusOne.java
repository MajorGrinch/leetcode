class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        for(int i = digits.length-1; i > 0; i--){
            digits[i-1] += digits[i] /10;
            digits[i] %= 10;
        }
        if(digits[0] <= 9 ){
            return digits;
        }else{
            int[] ans = new int[digits.length+1];
            ans[0] = digits[0] / 10;
            digits[0] %= 10;
            for(int i = 1; i < ans.length; i++){
                ans[i] = digits[i-1];
            }
            return ans;
        }
    }
}