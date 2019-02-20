class Solution {
    public boolean isPowerOfTwo(int n) {
        long x = 1;
        while(x < Integer.MAX_VALUE){
            System.out.println(x);
            if(n == x) return true;
            x = x << 1;
            if(x > n) return false;
        }
        return false;
    }
}

class Solution2{
    public boolean isPowerOfTwo(int n){
        return n > 0 && (n&n-1) == 0;
    }
}

class Solution3{
    public boolean isPowerOfTwo(int n){
        return n > 0 && 1073741824%n == 0;
    }
}

public class PowerofTwo{
    public static void main(String[] args) {
        int n = 1073741825;
        // int n = 3;
        System.out.println(new Solution().isPowerOfTwo(n));
    }
}