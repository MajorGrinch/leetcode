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

public class PowerofTwo{
    public static void main(String[] args) {
        int n = 1073741825;
        // int n = 3;
        System.out.println(new Solution().isPowerOfTwo(n));
    }
}