package Stack.Leetcodes;

import java.util.ArrayDeque;

class Solution {

    private class Node {
        int h;
        int lb;
        int index;

        Node(int h, int lb, int index){
            this.h = h;
            this.lb = lb;
            this.index = index;
        }
        
    }
    public int trap(int[] height) {
        ArrayDeque <Node> stack = new ArrayDeque<>();
        int res = 0;
        
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && stack.getLast().h <= height[i]){
                Node nd = stack.pollLast();
                int width = i - nd.index - 1;
                int hei = nd.h - nd.lb;
                res += width*hei;
                // System.out.printf("%d, %d, %d\n", width, hei, i);
            }
            if (stack.isEmpty()) {
                stack.addLast(new Node(height[i], 0, i));
            }
            else {
                Node n = stack.getLast();
                res += (height[i] - n.lb) * (i-n.index-1);
                n.lb = height[i];
                stack.addLast(new Node(height[i], 0, i));
            }
        }
        return res;
    }

}