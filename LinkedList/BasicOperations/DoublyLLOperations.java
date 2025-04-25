package LinkedList.BasicOperations;



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


class DoublyLinkedList {
    private DoublyListNode head;
    private DoublyListNode tail;
    
    // 在链表头部插入节点 - O(1)
    public void addAtHead(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    
    // 在链表尾部插入节点 - O(1) (因为有tail指针)
    public void addAtTail(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        
        if (tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    // 在指定位置插入节点 - O(n)
    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        DoublyListNode current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            // 如果索引等于链表长度，则添加到尾部
            if (index == size()) {
                addAtTail(val);
            }
            return;
        }
        
        // 在当前节点之前插入
        DoublyListNode newNode = new DoublyListNode(val);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
    }
    
    // 删除指定位置的节点 - O(n)
    public void deleteAtIndex(int index) {
        if (head == null || index < 0) return;
        
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        
        DoublyListNode current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) return;
        
        // 如果是尾节点
        if (current == tail) {
            tail = current.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }
    
    // 获取链表长度 - O(n)
    public int size() {
        int count = 0;
        DoublyListNode current = head;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    // 遍历链表 - O(n)
    public void traverse() {
        DoublyListNode current = head;
        
        System.out.print("null <- ");
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        
        System.out.println("null");
    }
}

