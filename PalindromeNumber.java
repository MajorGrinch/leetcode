class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        return x == reverse(x);
    }
    int reverse(int x){
        long N = x;
        long res = 0;
        while(N > 0){
            res *= 10;
            res += N % 10;
            N /= 10;
        }
        return (res > Integer.MAX_VALUE) ? 0 : (int)res;
    }
}