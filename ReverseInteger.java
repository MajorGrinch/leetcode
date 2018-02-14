class Solution {
    public int reverse(int x) {
        long N = x;
        long ans = 0;
        boolean is_neg = false;
        if(N < 0){
            is_neg = true;
            N = -N;
        }
        while(N > 0){
            ans *= 10;
            ans += N % 10;
            N /= 10;
        }
        if(is_neg){
            ans = -ans;
            return (ans<Integer.MIN_VALUE) ? 0 : (int)ans;
        }else{
            return (ans>Integer.MAX_VALUE) ? 0 : (int)ans;
        }      
    }
}