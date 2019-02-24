class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        return 1162261467%n == 0 ? true : false;
    }
}
public class PowerofThree{
    public static void main(String[] args) {
        long x = 3;
        while(x < Integer.MAX_VALUE) x *= 3;
        System.out.println(x/3);
    }
}