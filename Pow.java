class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean neg_n = false;
        if(N < 0){
            neg_n = true;
            N = -N;
        }
        double ans = 1, current_product = x;
        for(long i = N; i > 0; i /= 2){
            if(i%2 == 1){
                ans *= current_product;
            }
            current_product *= current_product;
        }
        if(neg_n){
            ans = 1 / ans;
        }
        return ans;
    }
}