package LinkedList.Problems;

public class HasCycle {
/**
 * 检测链表中是否有环
 * 时间复杂度: O(n) - 在最坏情况下，快指针需要遍历整个链表
 * 空间复杂度: O(1) - 只使用两个指针的额外空间
 */
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;        // 慢指针
    ListNode fast = head.next;   // 快指针
    
    while (slow != fast) {
        // 如果快指针到达末尾，说明没有环
        if (fast == null || fast.next == null) {
            return false;
        }
        
        slow = slow.next;       // 慢指针每次移动1步
        fast = fast.next.next;  // 快指针每次移动2步
    }
    
    return true;  // 如果快慢指针相遇，说明有环
}

}
