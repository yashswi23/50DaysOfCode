class LRUCache {
    int cap;
    Map<Integer,Integer> mp ;
    Deque<Integer> dq;

    public LRUCache(int capacity) {
        this.cap = capacity;
        mp = new HashMap<>();
        dq = new LinkedList<>();
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
            int last = dq.removeLast();
            mp.remove(last);
        }

        dq.addFirst(key);
        mp.put(key,value);

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */