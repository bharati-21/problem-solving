class Pair {
    int val, min;
    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    Deque<Pair> stack;
    public MinStack() {
        stack = new ArrayDeque();
    }
    
    public void push(int val) {
        int minVal = stack.isEmpty() ? val : Math.min(val, stack.peek().min);
        Pair pair = new Pair(val, minVal);
        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
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