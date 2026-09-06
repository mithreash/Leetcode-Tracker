// Last updated: 9/6/2026, 10:11:26 AM
1class Solution {
2    public int splitArray( int[ ] nums , int  k )  {
3        int low = 0 , high = 0 ;
4        for( int  i : nums ){
5            high += i ;
6            low = Math.max( i , low ) ;
7        }
8        return find( low , high , nums , k ) ;
9    }
10    private int find( int l , int h , int n [ ] , int k ) {
11        if( l >h ) return l;
12        int c = 1 , m = l + ( h - l ) / 2 , sum = 0 ;
13        for(int i : n ) {
14            if( i + sum > m ){
15                sum = i ;
16                c ++ ;
17            }
18            else    sum += i ;
19        }
20        if(c <= k ) return find( l , m - 1 , n , k ) ;
21        return find( m + 1 , h , n , k ) ;
22    }
23}