package LinkedList.Problems;

public class MergeOrderedList {
    /**
 * 合并两个有序链表
 * 时间复杂度: O(m + n) - 其中m和n分别是两个链表的长度
 * 空间复杂度: O(1) - 只修改原有节点的指针，不创建新节点
 */
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 创建虚拟头节点
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    
    // 依次比较两个链表的节点值，取较小值的节点添加到结果链表
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }
    
    // 连接剩余部分
    tail.next = (l1 != null) ? l1 : l2;
    
    return dummy.next;
}

}
