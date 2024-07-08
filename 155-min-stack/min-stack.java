class MinStack {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> minStack = new Stack();

    public MinStack() {
        
    }
    
    public void push(int val) {
        
        if(stack1.isEmpty()) {
            stack1.push(val);
            minStack.push(val);
        } else {
            stack1.push(val);
        }

        if(!stack1.isEmpty() && val <= minStack.peek()) {
            minStack.push(val);
        }

        
    }
    
    public void pop() {
        
        if(stack1.peek().equals(minStack.peek())) {
            stack1.pop();
            minStack.pop();
        } else {
            stack1.pop();
        }

        
    }
    
    public int top() {
        
        return stack1.peek();
    }
    
    public int getMin() {
        
        return minStack.peek();
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