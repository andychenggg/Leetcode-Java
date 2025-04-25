package LinkedList.Problems;

public class IntersectionNode {
    /**
 * 找到两个链表的交点
 * 时间复杂度: O(m + n) - 其中m和n分别是两个链表的长度
 * 空间复杂度: O(1) - 只使用两个指针的额外空间
 */
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    
    ListNode pA = headA;
    ListNode pB = headB;
    
    // 当pA与pB相等时退出循环，可能是交点，也可能都是null
    while (pA != pB) {
        // 遍历完A链表后转到B链表
        pA = pA == null ? headB : pA.next;
        // 遍历完B链表后转到A链表
        pB = pB == null ? headA : pB.next;
    }
    
    return pA;  // 返回交点或null
}

}
