class Solution {
    public int addDigits(int num) {
        int n = num;
        int ans = 0;
        while(true){
            ans = 0;
            while(n > 0){
                ans += n % 10;
                n /= 10;
            }
            if(ans < 10){
                break;
            }
            n = ans;
        }
        return ans;    
    }
}