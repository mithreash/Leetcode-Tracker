// Last updated: 9/6/2026, 10:06:11 AM
1class RandomizedCollection {
2    static class Node {
3        int index, value;
4        public Node(int i, int v) {
5            index = i;
6            value = v;
7        }
8    }
9
10    HashMap<Integer, LinkedList<Node>> valueToNodes = new HashMap<Integer, LinkedList<Node>>();
11    ArrayList<Node> arr = new ArrayList<Node>();
12    Random rand = new Random();
13    
14    /** Initialize your data structure here. */
15    public RandomizedCollection() {
16        
17    }
18    
19    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
20    public boolean insert(int val) {
21        LinkedList<Node> nodes = valueToNodes.get(val);
22        boolean res = false;
23        if (nodes == null) {
24            nodes = new LinkedList<Node>();
25            valueToNodes.put(val, nodes);
26            res = true;
27        }
28        Node node = new Node(arr.size(), val);
29        arr.add(node);
30        nodes.add(node);
31        return res;
32    }
33    
34    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
35    public boolean remove(int val) {
36        LinkedList<Node> nodes = valueToNodes.get(val);
37        if (nodes == null) {
38            return false;
39        }
40        Node nodeToRemove = nodes.removeFirst();
41        if (nodes.isEmpty()) {
42            valueToNodes.remove(val);
43        }
44        int lastIndexInArr = arr.size() - 1;
45        if (nodeToRemove.index == lastIndexInArr) {
46            arr.remove(lastIndexInArr);
47        } else {
48            Node lastNode = arr.get(lastIndexInArr);
49            lastNode.index = nodeToRemove.index;
50            arr.set(lastNode.index, lastNode);
51            arr.remove(lastIndexInArr);                
52        }
53        
54        return true;
55    }
56    
57    /** Get a random element from the collection. */
58    public int getRandom() {
59        return arr.get(rand.nextInt(arr.size())).value;
60    }
61}