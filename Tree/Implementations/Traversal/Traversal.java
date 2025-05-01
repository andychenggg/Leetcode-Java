package Tree.Implementations.Traversal;

import java.util.ArrayList;

import Tree.Implementations.TreeNode;

public abstract class Traversal {
    public abstract void recursiveTraversal(TreeNode root, ArrayList<Integer> res);
    public abstract void iterativeTraversal(TreeNode root, ArrayList<Integer> res);

}
