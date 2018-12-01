import java.util.Arrays;

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

class Solution2{
    public int countPrimes(int n){
        if(n <= 2) return 0;
        boolean[] notPrime = new boolean[n];
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]) ans++;
            int ed = (n%i == 0 ? n / i : n/i+1);
            for(int j = 2; j < ed; j++){
                notPrime[i*j] = true;
            }
        }
        return ans;
    }
}

/**
 * avoid replicated calculate.
 * if i is not prime, then all the composite numbers that could be derived
 * by i have already been derived by the factor of i. So when i is not prime,
 * skip the derivation.
 * Also, the derivation should start at i*i. Any composite number that is less
 * than i*i has already been derived by previous iterations. For example, if 3 < i,
 * you set 3 * i to false, while 3 * i has already been set to false in the iteration
 * where i = 3.
 */
class Solution{
    public int countPrimes(int n){
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i < n; i++){
            if(!isPrime[i]) continue;
            for(int j = i*i; j < n; j+=i){
                isPrime[j] = false;
            }
        }
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]) ans++;
        }
        return ans;
    }
}
public class CountPrimes{
    public static void main(String[] args) {
        Solution3 slu = new Solution3();
        System.out.println(slu.countPrimes(10));
    }
}