package Tree.Leetcodes;

import java.util.ArrayDeque;

public class Leetcode104 {
    
}


class Solution {

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        traversal(root, 0);
        return maxDepth;
    }

    public void traversal(TreeNode root, int level){
        if(root == null) return;
        int curLevel = level+1;
        maxDepth = maxDepth > curLevel? maxDepth: curLevel;

        traversal(root.left, curLevel);
        traversal(root.right, curLevel);
    }
}