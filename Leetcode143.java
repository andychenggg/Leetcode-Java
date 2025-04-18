public class Leetcode143 {
    public static void main(String[] args) {
        
    }



    
}


// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow == null){
            return;
        }

        ListNode head1 = head;
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        while (head1 != null && head2 != null) {
            ListNode tmp = head1.next;
            head1.next = head2;
            head1 = tmp;

            tmp = head2.next;
            head2.next = head1;
            head2 = tmp;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode tail = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = tmp;
        }
        return tail;
    }
}