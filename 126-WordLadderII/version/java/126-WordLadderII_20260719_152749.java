// Last updated: 7/19/2026, 3:27:49 PM
1class LRUCache {
2    class Node{
3        int key;
4        int value;
5
6        Node prev;
7        Node next;
8
9        Node(int key, int value){
10            this.key= key;
11            this.value= value;
12        }
13    }
14
15    public Node[] map;
16    public int count, capacity;
17    public Node head, tail;
18    
19    public LRUCache(int capacity) {
20        
21        this.capacity= capacity;
22        count= 0;
23        
24        map= new Node[10_000+1];
25        
26        head= new Node(0,0);
27        tail= new Node(0,0);
28        
29        head.next= tail;
30        tail.prev= head;
31        
32        head.prev= null;
33        tail.next= null;
34    }
35    
36    public void deleteNode(Node node){
37        node.prev.next= node.next;
38        node.next.prev= node.prev;       
39        
40        return;
41    }
42    
43    public void addToHead(Node node){
44        node.next= head.next;
45        node.next.prev= node;
46        node.prev= head;
47        
48        head.next= node;      
49        
50        return;
51    }
52    
53    public int get(int key) {
54        
55        if( map[key] != null ){
56            
57            Node node= map[key];
58            
59            int nodeVal= node.value;
60            
61            deleteNode(node);
62            
63            addToHead(node);
64            
65            return nodeVal;
66        }
67        else
68            return -1;
69    }
70    
71    public void put(int key, int value) {
72        
73        if(map[key] != null){
74            
75            Node node= map[key];
76            
77            node.value= value;
78            
79            deleteNode(node);
80            
81            addToHead(node);
82            
83        } else {
84            
85            Node node= new Node(key,value);
86            
87            map[key]= node;
88            
89            if(count < capacity){
90                count++;
91                addToHead(node);
92            } 
93            else {
94                
95                map[tail.prev.key]= null;
96                deleteNode(tail.prev);
97                
98                addToHead(node);
99            }
100        }
101        
102        return;
103    }
104    
105}