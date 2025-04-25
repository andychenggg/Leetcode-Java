package LinkedList.Leetcodes;


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

 class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                fast = head;
                while(true){
                    if (fast == slow){
                        return fast;
                    }
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }
}
