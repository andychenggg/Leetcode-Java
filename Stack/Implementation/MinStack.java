package Stack.Implementation;

public class MinStack {
    private Node top;
    
    private class Node {
        int val;
        int min;
        Node next;
        
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    public MinStack() {
        // 初始化栈
    }
    
    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            // 每个节点记录当前栈的最小值
            top = new Node(val, Math.min(val, top.min), top);
        }
    }
    
    public void pop() {
        if (top == null) throw new EmptyStackException();
        top = top.next;
    }
    
    public int top() {
        if (top == null) throw new EmptyStackException();
        return top.val;
    }
    
    public int getMin() {
        if (top == null) throw new EmptyStackException();
        return top.min;
    }
}

