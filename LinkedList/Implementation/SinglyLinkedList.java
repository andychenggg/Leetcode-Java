package LinkedList.Implementation;

// 单向链表的基本结构
class SinglyLinkedList {
    private ListNode head;  // 头节点
    
    public SinglyLinkedList() {
        this.head = null;
    }
    
    // 其他方法...
}

// 单向链表节点定义
class ListNode {
    int val;          // 数据域
    ListNode next;    // 指针域
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
