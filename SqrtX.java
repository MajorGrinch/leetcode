class Solution {
    public int mySqrt(int c) {
        double err = 1e-15;
        double t = c;
        while(Math.abs(t - c/t) > t*err)
            t = (c/t + t) / 2.0;
        return (int)t;
    }
}