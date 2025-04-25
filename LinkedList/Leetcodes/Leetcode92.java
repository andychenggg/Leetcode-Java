package LinkedList.Leetcodes;

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode(), pre = fakeHead, tail = fakeHead;
        fakeHead.next = head;

        while(--left > 0) pre = pre.next;
        while(right-- >= 0) tail = tail.next;

        ListNode nxt = tail;
        while(pre.next != nxt){
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = tail;
            tail = cur;
        }
        pre.next = tail;

        return fakeHead.next;
    }
}