package Stack.Implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicStack {
    private Deque<Integer> stack;
    
    public MonotonicStack() {
        stack = new ArrayDeque<>();
    }
    
    // 维护一个单调递增栈
    public void pushIncreasing(int val) {
        while (!stack.isEmpty() && stack.peek() > val) {
            stack.pop();
        }
        stack.push(val);
    }
    
    // 维护一个单调递减栈
    public void pushDecreasing(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            stack.pop();
        }
        stack.push(val);
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

