package LinkedList.Leetcodes;



 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur =  new ListNode();
        ListNode head = cur;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }

        }
        while(list1 != null){
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        while(list2 != null){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;

        }
        return head.next;
    }
}
 