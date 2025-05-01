package Tree.Leetcodes;

public class Leetcode129 {
    
}
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        addToSum(root, 0);
        return sum;
    }

    public void addToSum(TreeNode root, int parentSum){
        if(root.left == null && root.right == null){
            sum += parentSum * 10 + root.val;
            return;
        }

        if(root.left != null){
            addToSum(root.left, parentSum * 10 + root.val);
        }

        if(root.right != null){
            addToSum(root.right, parentSum * 10 + root.val);
        }
    }
}