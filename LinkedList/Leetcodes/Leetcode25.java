package LinkedList.Leetcodes;

/**
 * Codetop3, Leetcode 25:
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode head = new Solution().reverseKGroup(l1, 2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }


    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(), cur = pre;
        pre.next = head;
        while(true){
            ListNode res = reverseK(cur, k);
            if(res == null){
                break;
            }
            else cur = res;
        }
        return pre.next;
    }

    public ListNode reverseK(ListNode pre, int k){
        ListNode cur = pre.next, res = cur;
        ListNode tail = pre;
        for (int i = 0; i < k+1; i++) {
            if(tail == null){
                return null;
            }
            tail = tail.next;
        }
        for (int i = 0; i < k; i++) {
            pre.next = cur;
            ListNode temp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = temp;
        }
        return res;

    }

}