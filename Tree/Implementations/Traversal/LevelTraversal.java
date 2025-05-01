package Tree.Implementations.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;

import Tree.Implementations.TreeNode;

public class LevelTraversal{
    public void traversal(TreeNode root, ArrayList<Integer> res){
        if (root == null) return;
        
        ArrayDeque <TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while(!q.isEmpty()){
            TreeNode rt = q.pollFirst();
            res.add(rt.val);

            if(rt.left != null) q.addLast(rt.left);
            if(rt.right != null) q.addLast(rt.right);

        }
    }
}
