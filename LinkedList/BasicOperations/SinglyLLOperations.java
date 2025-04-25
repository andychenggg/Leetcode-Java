package LinkedList.BasicOperations;

class ListNode {
    int val;          // 数据域
    ListNode next;    // 指针域
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class SinglyLinkedList {
    private ListNode head;
    
    // 在链表头部插入节点 - O(1)
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }
    
    // 在链表尾部插入节点 - O(n)
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newNode;
    }
    
    // 在指定位置插入节点 - O(n)
    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        ListNode current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) return;
        
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
    }
    
    // 在指定节点后插入新节点 - O(1) (假设已知节点)
    public void insertAfterNode(ListNode node, int val) {
        if (node == null) return;
        
        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
    }
    
    // 删除指定位置的节点 - O(n)
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) return;
        
        if (index == 0) {
            head = head.next;
            return;
        }
        
        ListNode current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        
        if (current.next == null) return;
        
        current.next = current.next.next;
    }
    
    // 查找指定值的节点 - O(n)
    public ListNode find(int val) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val == val) {
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    // 获取指定节点的前一个节点 - O(n)
    public ListNode getPrevious(ListNode node) {
        if (head == null || node == null || head == node) {
            return null;
        }
        
        ListNode current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }
        
        return current;
    }
    
    // 遍历链表 - O(n)
    public void traverse() {
        ListNode current = head;
        
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        
        System.out.println("null");
    }
}

