package Queue.Leetcodes;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private class Pair {
        int val;
        int index;
        Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
        
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        ArrayDeque<Pair> q =  new ArrayDeque<>(k);

        int [] res = new int[nums.length-k+1];
        int p = 0;
        for (int i = 0; i < nums.length && i < k; i++) {
            addToQ(q, new Pair(nums[i], i));
        }
        res[p++] = q.peekFirst().val;
        for (int i = k; i < nums.length; i++) {
            if (q.peekFirst().index == i-k){
                q.removeFirst();
            }
            addToQ(q, new Pair(nums[i], i));
            res[p++] = q.peekFirst().val;
            
        }
        return res;
    }

    public void addToQ(ArrayDeque<Pair> q, Pair p){
        while(!q.isEmpty() && q.peekLast().val <= p.val) q.pollLast();
        q.addLast(p);
    }
}