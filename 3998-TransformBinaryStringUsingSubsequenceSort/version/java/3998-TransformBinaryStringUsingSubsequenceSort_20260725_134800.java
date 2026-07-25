// Last updated: 7/25/2026, 1:48:00 PM
1class Solution {
2    public boolean[] transformStr(String s, String[] strs) {
3        int n=s.length();
4        int count=0;
5        boolean res[]=new boolean[strs.length];
6        for(char ch:s.toCharArray()){
7            if(ch=='1'){
8                count++;
9            }
10        }
11        int position[]=new int[count];
12        int ind=0;
13        for(int i=0;i<s.length();i++){
14            if(s.charAt(i)=='1'){
15                position[ind++]=i;
16            }
17        }
18        for(int i=0;i<strs.length;i++){
19            String curr=strs[i];
20            int first=0;
21            int second=0;
22            for(int j=0;j<n;j++){
23                char ch=curr.charAt(j);
24                if(ch=='1'){
25                    first++;
26                }
27                else if(ch=='?'){
28                    second++;
29                }}
30                if(first>count||first+second<count){
31                    res[i]=false;
32                    continue;
33                }
34                int need=count-first;
35                int skip=second-need;
36                int secondind=0;
37                boolean flag=true;
38                for(int j=0;j<n;j++){
39                    char ch=curr.charAt(j);
40                    if(ch=='1'){
41                        if(j<position[secondind]){
42                            flag=false;
43                            break;
44                        }
45                        secondind++;
46                    }
47                    else if(ch=='?'){
48                        if(skip>0){
49                            skip--;
50                        }
51                        else{
52                            if(j<position[secondind]){
53                                flag=false;
54                                break;
55                            }
56                            secondind++;
57                        }
58                    }
59                }
60            res[i]=flag;
61            }
62        return res;
63        }
64    }