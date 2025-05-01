package Tree.Leetcodes;

public class Leetcode105 {
    
}
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int l1, int r1, int [] inorder, int l2, int r2){
        if(l1 > r1) return null;
        // System.out.print(l1+" ");
        TreeNode root = new TreeNode(preorder[l1]);
        int rootIdx = l2;
        while (inorder[rootIdx] != preorder[l1]) rootIdx++;
        int lLen = rootIdx-l2, rLen = r2-rootIdx;
        // System.out.print(rootIdx+" "+lLen);
        // System.out.println();

        root.left = buildTree(preorder, l1+1, l1+lLen, inorder, l2, rootIdx-1);
        root.right = buildTree(preorder, r1-rLen+1, r1, inorder, rootIdx+1, r2);
        return root;
    }
}