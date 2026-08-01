// Last updated: 8/1/2026, 9:26:17 AM
1class PeekingIterator implements Iterator<Integer> {
2    
3    Iterator<Integer> iter = null;
4    Integer next = null;
5    
6	public PeekingIterator(Iterator<Integer> iterator) {
7	    // initialize any member here.
8	    iter = iterator;
9        if(hasNext()) next = iter.next();
10	}
11	
12	public Integer peek() {
13        return next;
14	}
15	
16	@Override
17	public Integer next() {
18	    Integer currVal = next;
19        if(iter.hasNext()) 
20            next = iter.next();
21        else 
22            next = null;
23        return currVal;
24	}
25	
26	@Override
27	public boolean hasNext() {
28	    return next != null || iter.hasNext();
29	}
30}