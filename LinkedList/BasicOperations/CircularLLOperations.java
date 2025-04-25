package LinkedList.BasicOperations;

class CircularLinkedList {
    private ListNode head;
    
    // 在链表尾部添加节点 - O(n)
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
    
    // 在指定位置插入节点 - O(n)
    public void insertAt(int index, int val) {
        if (index < 0) return;
        
        ListNode newNode = new ListNode(val);
        
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }
        
        if (index == 0) {
            // 插入头部
            ListNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            newNode.next = head;
            last.next = newNode;
            head = newNode;
            return;
        }
        
        // 找到要插入位置的前一个节点
        ListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == head) break;  // 防止无限循环
        }
        
        newNode.next = current.next;
        current.next = newNode;
    }
    
    // 删除指定位置的节点 - O(n)
    public void deleteAt(int index) {
        if (head == null || index < 0) return;
        
        if (index == 0) {
            // 删除头节点
            if (head.next == head) {
                head = null;  // 只有一个节点的情况
                return;
            }
            
            ListNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            head = head.next;
            last.next = head;
            return;
        }
        
        // 找到要删除节点的前一个节点
        ListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == head) return;  // 索引超出范围
        }
        
        if (current.next == head) return;  // 索引超出范围
        
        current.next = current.next.next;
    }
    
    // 遍历循环链表 - O(n)
    public void traverse() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        
        ListNode current = head;
        do {
            System.out.print(current.val + " -> ");
            current = current.next;
        } while (current != head);
        
        System.out.println("(head)");
    }
}

