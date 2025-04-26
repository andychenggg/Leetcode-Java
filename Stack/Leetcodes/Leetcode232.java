package Stack.Leetcodes;

import java.util.ArrayDeque;

class MyQueue {

    private ArrayDeque<Integer> popStack;
    private ArrayDeque<Integer> pushStack;
    public MyQueue() {
        popStack = new ArrayDeque<>();
        pushStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        pushStack.addLast(x);
    }
    
    public int pop() {
        if (popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.addLast(pushStack.pollLast());
            }
        }
        return popStack.pollLast();
    }
    
    public int peek() {
        if (popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.addLast(pushStack.pollLast());
            }
        }
        return popStack.peekLast();
    }
    
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */