package Stack.Leetcodes;

import java.util.ArrayDeque;
import java.util.Objects;

class MinStack {

    ArrayDeque <Integer> stack = new ArrayDeque<>();
    ArrayDeque <Integer> minStk = new ArrayDeque<>();

    public MinStack() {
        stack = new ArrayDeque<>();
        minStk = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(minStk.isEmpty() || minStk.peekLast() >= val){
            minStk.addLast(val);
        }
    }
    
    public void pop() {
        
        if (Objects.equals(minStk.peekLast(), stack.peekLast())){
            minStk.pollLast();
        }
        stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStk.peekLast();
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
