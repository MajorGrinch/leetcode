class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int ans = 1;
        for(int i = 3; i < n; i++){
            if(isPrime(i)) ans++;
        }
        return ans;
    }
    private boolean isPrime(int x){
        int ed = (int)Math.sqrt(x) + 1;
        for(int i = 2; i <= ed; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}