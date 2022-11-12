class MinStack {
    Stack<Pair<Integer, Integer>> stack;
    
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new Pair(val, val));
        }
        else {
            int min = stack.peek().getValue(); 
            if(val < min) min = val;
            stack.push(new Pair(val, min));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
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