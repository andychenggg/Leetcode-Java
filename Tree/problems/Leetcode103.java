package Tree.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode103 {
    
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    private class Pair {
        TreeNode tn;
        int level;
        Pair(TreeNode tn, int level){
            this.tn = tn;
            this.level = level;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<Pair> dq = new ArrayDeque<>();

        dq.addLast(new Pair(root, 0));

        ArrayList <Integer>  nor = new ArrayList<>(), rev = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();

        while (!dq.isEmpty()) {
            Pair e = dq.removeFirst();
            if(e.tn.left != null){
                dq.addLast(new Pair(e.tn.left, e.level+1));
            }
            if(e.tn.right != null){
                dq.addLast(new Pair(e.tn.right, e.level+1));
            }

            if (e.level % 2 == 0){
                nor.add(e.tn.val);
                if(!rev.isEmpty()){
                    Collections.reverse(rev);
                    res.add(rev);
                    rev = new ArrayList<>();
                }
            
            }
            else {
                rev.add(e.tn.val);
                if(!nor.isEmpty()){
                    res.add(nor);
                    nor = new ArrayList<>();
                }
            }
        }
        if(!rev.isEmpty()){
            Collections.reverse(rev);
            res.add(rev);
        }
        if(!nor.isEmpty()){
            res.add(nor);
        }

        return res;
    }
}
