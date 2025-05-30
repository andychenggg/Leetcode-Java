package Tree.Leetcodes;

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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r){
        if (l == null && r==null) return true;
        if(l == null || r == null) return false;
        return l.val == r.val && isSymmetric(l.right, r.left) && isSymmetric(l.left, r.right);
    }
}
