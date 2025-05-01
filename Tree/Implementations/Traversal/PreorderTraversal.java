package Tree.Implementations.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;

import Tree.Implementations.TreeNode;

public class PreorderTraversal extends Traversal{
    @Override
    public void recursiveTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;

        res.add(root.val);

        recursiveTraversal(root.left, res);
        recursiveTraversal(root.right, res);
    }

    @Override
    public void iterativeTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;

        ArrayDeque <TreeNode> q = new ArrayDeque<>();
        q.push(root);

        while(!q.isEmpty()){
            TreeNode rt = q.pollLast();
            res.add(rt.val);

            if (rt.right != null) q.addLast(rt.right);
            if (rt.left != null) q.addLast(rt.left);

        }


    }
}
