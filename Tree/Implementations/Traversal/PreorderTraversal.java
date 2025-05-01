package Tree.Implementations.Traversal;

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
        


    }
}
