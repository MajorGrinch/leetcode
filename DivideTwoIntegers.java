class Solution {
    public int divide(int dividend, int divisor) {
        char sign = '+';
        if(dividend >> 31 != divisor >> 31) sign = '-';
        long ldividend = dividend;
        long ldivisor = divisor;
        ldividend = ldividend < 0 ? -ldividend : ldividend;
        ldivisor = ldivisor < 0 ? -ldivisor : ldivisor;
        long quotient = 0;
        // System.out.printf("ldividend = %d, ldivisor = %d, sign = %c\n", ldividend, ldivisor, sign);
        while(ldividend >= ldivisor){
            ldividend -= ldivisor;
            quotient++;
        }
        quotient = sign == '-' ? -quotient : quotient;
        if(quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)quotient;
    }
}
public class DivideTwoIntegers{
    public static void main(String[] args) {
        System.out.println(new Solution().divide(10, 3));
    }
}