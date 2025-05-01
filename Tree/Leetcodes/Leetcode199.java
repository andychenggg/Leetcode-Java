package Tree.Leetcodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode199 {
    
}
class Solution {
    private class Pair {
        int level;
        TreeNode tn;
        Pair(int level, TreeNode tn){
            this.tn = tn;
            this.level = level;
        }
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Pair> q = new ArrayDeque<>();

        if (root == null) return res;
        Pair last = null;

        q.addLast(new Pair(0, root));

        while(!q.isEmpty()){
            Pair pair = q.pollFirst();
            if (last == null || last.level == pair.level){
                last = pair;
            }
            else {
                res.add(last.tn.val);
                last = pair;
            }

            if(pair.tn.left != null){
                q.add(new Pair(pair.level+1, pair.tn.left));
            }
            if(pair.tn.right != null){
                q.add(new Pair(pair.level+1, pair.tn.right));
            }
        }
        res.add(last.tn.val);
        return res;
    }
}