// Last updated: 9/6/2026, 9:34:08 AM
1import java.math.BigInteger;
2
3class Solution {
4    public int superPow(int a, int[] b) {
5      StringBuilder str=new StringBuilder();
6      for(int i=0; i<b.length; i++)
7      {
8        str.append(Integer.toString(b[i]));
9      }
10      String st=str.toString();
11      BigInteger exponent=new BigInteger(st);
12      BigInteger base=BigInteger.valueOf(a);
13      BigInteger ans=base.modPow(exponent, BigInteger.valueOf(1337));
14      return ans.intValue();
15    }
16}