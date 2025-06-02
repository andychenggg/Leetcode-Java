package LinkedList.Leetcodes;


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode slow = prehead, fast = slow.next;
        while (fast != null) {
            boolean removeFlag = false;
            while(fast.next != null && fast.val == fast.next.val){
                removeFlag = true;
                fast.next = fast.next.next;
            }
            if (removeFlag){
                fast = fast.next;
                slow.next = fast;
            }  
            else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return prehead.next;
    }
}
