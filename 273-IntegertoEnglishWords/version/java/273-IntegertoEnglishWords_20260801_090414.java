// Last updated: 8/1/2026, 9:04:14 AM
1public class Solution {
2    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
3    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
4    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
5    
6    public String numberToWords(int num) {
7        if (num == 0) return "Zero";
8        return helper(num); 
9    }
10    
11    private String helper(int num) {
12        String result = new String();
13        if (num < 10) result = belowTen[num];
14        else if (num < 20) result = belowTwenty[num -10];
15        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
16        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
17        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
18        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
19        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
20        return result.trim();
21    }
22}