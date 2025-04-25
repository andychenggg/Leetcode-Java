package LinkedList.Problems;

public class MiddleNode {
    /**
 * 找到链表的中间节点
 * 时间复杂度: O(n) - 只需要遍历一半的链表
 * 空间复杂度: O(1) - 只使用两个指针的额外空间
 */
public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    
    // 快指针每次移动两步，慢指针每次移动一步
    // 当快指针到达末尾时，慢指针恰好在中间
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    return slow;
}

}
