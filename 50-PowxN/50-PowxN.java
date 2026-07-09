// Last updated: 7/9/2026, 3:09:18 PM
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        double base = x;
        while (N > 0) {
            if ((N & 1) == 1) result *= base;
            base *= base;
            N >>= 1;
        }
        return result;
    }
}
