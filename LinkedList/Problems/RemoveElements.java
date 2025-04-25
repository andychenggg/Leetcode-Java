package LinkedList.Problems;

public class RemoveElements {
    /**
 * 删除链表中值为指定值的所有节点
 * 时间复杂度: O(n) - 需要遍历整个链表
 * 空间复杂度: O(1) - 只使用常数额外空间
 */
public ListNode removeElements(ListNode head, int val) {
    // 创建虚拟头节点简化操作
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    ListNode curr = dummy;
    while (curr.next != null) {
        if (curr.next.val == val) {
            curr.next = curr.next.next;  // 删除匹配值的节点
        } else {
            curr = curr.next;  // 移动到下一个节点
        }
    }
    
    return dummy.next;
}

}
