// Last updated: 7/9/2026, 3:07:04 PM
class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int squareSum = 0;

        while (n > 0) {
            int digit = n % 10;

            digitSum += digit;
            squareSum += digit * digit;

            n /= 10;
        }

        return (squareSum - digitSum) >= 50;
    }
}