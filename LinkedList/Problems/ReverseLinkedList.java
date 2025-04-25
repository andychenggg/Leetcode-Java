package LinkedList.Problems;


class ListNode {
    int val;          // 数据域
    ListNode next;    // 指针域
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

/**
 * 反转单链表
 * 时间复杂度: O(n) - 只需遍历链表一次
 * 空间复杂度: O(1) - 只使用常数额外空间
 */
public ListNode reverseList(ListNode head) {
    ListNode prev = null;    // 前一个节点
    ListNode curr = head;    // 当前节点
    
    while (curr != null) {
        ListNode next = curr.next;  // 暂存下一个节点
        curr.next = prev;           // 反转当前节点的指针
        prev = curr;                // 前一个节点向前移动
        curr = next;                // 当前节点向前移动
    }
    
    return prev;  // 新的头节点
}
}


