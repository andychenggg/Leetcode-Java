package Tree.Implementations.Traversal;

import java.util.ArrayList;

import Tree.Implementations.TreeNode;

public class PostorderTraversal extends Traversal {
    
    @Override
    public  void recursiveTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null)return;

        recursiveTraversal(root.left, res);
        recursiveTraversal(root.right, res);

        res.add(root.val);
    }

    @Override
    public  void iterativeTraversal(TreeNode root, ArrayList<Integer> res){

    }

}
