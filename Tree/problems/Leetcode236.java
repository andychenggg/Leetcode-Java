 package Tree.problems;

 public class Leetcode236 {

    
}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPorQ(root, p, q);
        return ans;
    }

    public boolean findPorQ(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean l_find = findPorQ(root.left, p, q);
        boolean r_find = findPorQ(root.right, p, q);
        if (l_find && r_find || 
        l_find && (root.val == p.val || root.val == q.val) || 
        r_find && (root.val == p.val || root.val == q.val)){
            ans = root;
            return true;
        }

        return root.val == p.val || root.val == q.val || l_find || r_find;
    }
}