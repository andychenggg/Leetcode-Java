package LinkedList.Implementation;

// 单向循环链表实现
class CircularLinkedList {
    private ListNode head;  // 头节点
    
    public CircularLinkedList() {
        this.head = null;
    }
    
    // 添加节点到循环链表末尾
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        
        if (head == null) {
            head = newNode;
            head.next = head;  // 指向自身形成环
            return;
        }
        
        ListNode current = head;
        // 找到最后一个节点
        while (current.next != head) {
            current = current.next;
        }
        
        current.next = newNode;
        newNode.next = head;  // 新节点指向头节点形成环
    }
    
    // 其他方法...
}
