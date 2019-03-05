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

class Solution2{
    public int divide(int dividend, int divisor){
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long ldividend = dividend, ldivisor = divisor, quotient = 0;
        ldividend = Math.abs(ldividend);
        ldivisor = Math.abs(ldivisor);
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        while(ldividend >= ldivisor){
            long tmpDvs = ldivisor, cl = 0;
            while(tmpDvs*2 < ldividend){
                cl++;
                tmpDvs <<= 1;
            }
            ldividend -= tmpDvs;
            // System.out.println(cl);
            quotient += (1<<cl);
        }
        return (int)(sign * quotient);
    }
}
public class DivideTwoIntegers{
    public static void main(String[] args) {
        System.out.println(new Solution().divide(10, 3));
    }
}