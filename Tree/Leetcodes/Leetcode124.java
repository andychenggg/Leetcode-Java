package Tree.Leetcodes;
import java.lang.Math;
public class Leetcode124 {
    
}

class Solution {

    

    int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root){
        if(root == null) return 0;

        int lGain = maxGain(root.left), rGain = maxGain(root.right);
        recalMaxSum(root.val, root.val+lGain, root.val+rGain, lGain+root.val+rGain);

        return Math.max(Math.max(lGain+root.val, rGain+root.val), root.val);

    }

    public void recalMaxSum(int... nums){
        for(int i: nums){
            if (i > maxSum) maxSum = i;
        }
    }

    
}
