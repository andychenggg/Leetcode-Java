import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode23 {
    
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        // mergeKLists(lists, 0, lists.length-1);

        // return lists[0];
        return mergeKListsPQ(lists);
    }

    /**
     * Divide and conquer, similar to merge sort
     * Time Complexity: O(nklogk)
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public void mergeKLists(ListNode[] lists, int l, int r){
        if(l >= r){
            return;
        }
        
        int mid = (l+r)/2;

        mergeKLists(lists, l, mid);
        mergeKLists(lists, mid+1, r);

        // merge and store in left-most 
        ListNode head = new ListNode();

        ListNode n1 = lists[l], n2 = lists[mid+1], cur = head;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                cur.next = n1;
                n1 = n1.next;
                cur = cur.next;
            }
            else {
                cur.next = n2;
                n2 = n2.next;
                cur = cur.next;
            }
        }
        while (n1 != null){
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
        }
        while(n2 != null){
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
        }
        lists[l] = head.next;
    }

    /**
     * Use priority queue
     * Time complexity: O(nklogk)
     * @param lists
     */
    public ListNode mergeKListsPQ(ListNode[] lists){
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
        ListNode res = new ListNode(), cur = res;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                pq.add(new Pair(i, lists[i]));
                lists[i] = lists[i].next;
            }
        }
        while(!pq.isEmpty()){
            Pair pk = pq.poll();
            cur.next = pk.node;
            if(lists[pk.index] != null){
                pq.add(new Pair(pk.index, lists[pk.index]));
                lists[pk.index] = lists[pk.index].next;
            }
            cur = cur.next;
        }

        return res.next;
    }
    private class Pair {
        int index;
        ListNode node;
        Pair(int index, ListNode node){
            this.index = index;
            this.node = node;
        }
    }
}
