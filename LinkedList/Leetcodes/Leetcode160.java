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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        int switchTime = 0;
        while (pa != pb){
            pa = pa.next;
            pb = pb.next;

            if (pa == null) {
                pa = headB;
                switchTime++;
            }
            if (pb == null) {
                pb = headA;
                switchTime++;
            }
            if (switchTime > 2) return null;
        }

        return pa;
    }
}
