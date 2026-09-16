// Last updated: 9/16/2026, 9:19:55 AM
1class Solution {
2    // input types: determined by most significant 1 ~ 5 bits
3    static final int TYPE_0 = 0b00000000;
4    static final int TYPE_1 = 0b10000000;
5    static final int TYPE_2 = 0b11000000;
6    static final int TYPE_3 = 0b11100000;
7    static final int TYPE_4 = 0b11110000;
8    // masks for most significant 1 to 5 bis
9    static final int[] MASKS = new int[]{0b10000000, 0b11000000, 0b11100000, 0b11110000, 0b11111000};
10    // input type enumation
11    static final int[] TYPES = new int[]{TYPE_0, TYPE_1, TYPE_2, TYPE_3, TYPE_4};
12    // map of cur_stat : (input_type : next_stat)
13    static final Map<Integer, Map<Integer, Integer>> DFA = new HashMap<>();
14	
15	private static int getType(int in) {
16        // type 0: 0xxxxxxx
17        // type 1: 10xxxxxx
18        // type 2: 110xxxxx
19        // type 3: 1110xxxx
20        // type 4: 11110xxx
21        for (int i = 0; i < TYPES.length; i++) {
22            if ((MASKS[i] & in) == TYPES[i]) {
23                return TYPES[i];
24            }
25        }
26		// unreachable. unless input is "11111xxx" which is not a valid utf-8 character.
27        return -1;
28    }
29    // build the dfa
30    static {
31        DFA.put(0, Map.of(TYPE_0, 0, TYPE_2, 1, TYPE_3, 2, TYPE_4, 3));
32        DFA.put(1, Map.of(TYPE_1, 0));
33        DFA.put(2, Map.of(TYPE_1, 4));
34        DFA.put(4, Map.of(TYPE_1, 0));
35        DFA.put(3, Map.of(TYPE_1, 5));
36        DFA.put(5, Map.of(TYPE_1, 6));
37        DFA.put(6, Map.of(TYPE_1, 0));
38    }
39    
40    public boolean validUtf8(int[] data) {
41        int cur = 0;
42        for (int input : data) {
43            Integer next = getNext(cur, input);
44            if (next == null) {
45                return false;
46            }
47            cur = next;
48        }
49        return cur == 0;
50    }
51    
52    private static Integer getNext(int cur, int input) {
53        int type = getType(input);
54        if (type == -1) return null;
55        return DFA.get(cur).get(type);
56    }
57}