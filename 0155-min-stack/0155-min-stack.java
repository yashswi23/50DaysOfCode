class MinStack {
    Stack<Integer> main;
    Stack<Integer> mini;

    public  MinStack() {
        main = new Stack<>();
        mini = new Stack<>();
        
    }
    
    public void push(int val) {
        main.push(val);
        if(mini.isEmpty()|| mini.peek()>=val){
            mini.add(val);
        }
        
    }
    
    public void pop() {
        if(main.isEmpty()){
            return;
        }

        if(main.peek().equals(mini.peek())){
            mini.pop();
        }
        main.pop();
        
    }
    
    public int top() {
        if(main.isEmpty()) return 0;

        return main.peek();
        
    }
    
    public int getMin() {
        if(mini.isEmpty()) return 0;

        return mini.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */