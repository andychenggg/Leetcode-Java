public class CodeTop6 {
    public static void main(String[] args) {
        
    }
    /**
     * Codetop6, leetcode206
     * https://leetcode.cn/problems/reverse-linked-list/description/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, tail = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = temp;
        }
        return tail;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


