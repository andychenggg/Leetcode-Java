package Stack.Leetcodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // use stack

        ArrayDeque <TreeNode> stack = new ArrayDeque<>();
        ArrayList <Integer> res = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            res.add(root.val);
            root = root.right;

        }

        return res;
    }
}
