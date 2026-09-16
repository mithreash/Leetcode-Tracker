// Last updated: 9/16/2026, 2:57:11 PM
1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        ArrayList<String> result=new ArrayList<>();
4        for(int hh=0;hh<=11;hh++){
5            for(int mm=0;mm<=59;mm++){
6                if(Integer.bitCount(hh)+
7                Integer.bitCount(mm)==turnedOn){
8                    
9                    result.add(hh + ":" + (mm < 10 ? "0" : "") + mm);
10                }
11            }
12        }
13        return result;
14
15    }
16}