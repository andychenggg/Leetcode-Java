package LinkedList.Implementation;

// 双向链表节点定义
class DoublyListNode {
    int val;              // 数据域
    DoublyListNode prev;  // 指向前一个节点
    DoublyListNode next;  // 指向后一个节点
    
    public DoublyListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

// 双向链表的基本结构
class DoublyLinkedList {
    private DoublyListNode head;  // 头节点
    private DoublyListNode tail;  // 尾节点
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    // 其他方法...
}

