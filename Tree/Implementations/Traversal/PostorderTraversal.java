package Tree.Implementations.Traversal;

import java.util.ArrayDeque;
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
        if(root == null) return;

        ArrayDeque <TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque <TreeNode> stack2 = new ArrayDeque<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode rt = stack1.pop();
            stack2.push(rt);
            if(rt.left != null) stack1.push(rt.left);
            if(rt.right != null) stack1.push(rt.right);

        }

        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
    }

}
