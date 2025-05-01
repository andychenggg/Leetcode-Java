package Tree.Implementations.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;

import Tree.Implementations.TreeNode;

public class InorderTraversal extends Traversal{
    @Override
    public  void recursiveTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;

        recursiveTraversal(root.left, res);
        res.add(root.val);
        recursiveTraversal(root.right, res);


    }

    @Override
    public  void iterativeTraversal(TreeNode root, ArrayList<Integer> res){
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
    }

}
