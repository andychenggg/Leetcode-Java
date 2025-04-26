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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.addLast(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pollLast();
            root = root.right;

        }

        return res;
    }
}
