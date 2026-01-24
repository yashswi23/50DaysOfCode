class LRUCache {
    int cap;
    Deque<Integer> dq ;
    Map<Integer,Integer> mp;

    public LRUCache(int capacity) {
        this.cap = capacity;
        dq = new LinkedList<>();
        mp = new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
           return -1;
        }
         dq.remove(key);
        dq.addFirst(key);
        return mp.get(key);
        
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            dq.remove(key);
        }
        else if(mp.size() == cap){
           int last =  dq.pollLast();
            mp.remove(last);
        }

        mp.put(key,value);
        dq.addFirst(key);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */