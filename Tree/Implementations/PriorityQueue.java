package Tree.Implementations;

import java.util.ArrayList;

class MinHeapNode {
    int key;
    MinHeapNode left;
    MinHeapNode right;
    MinHeapNode parent;
    MinHeapNode(int key){
        this.key = key;
    }

    public MinHeapNode reorder(int newKey){
        key = newKey;
        MinHeapNode res = this;
        while (res.parent != null && res.key < res.parent.key){
            int temp = res.parent.key;
            res.parent.key = res.key;
            res.key = temp;
            res = res.parent;
        }
        while (res.left != null && res.key > res.left.key || 
            res.right != null && res.key > res.right.key){
            if (res.left != null && res.key > res.left.key ){
                int temp = res.key;
                res.key = res.left.key;
                res.left.key = temp;
                res = res.left;
            }
            else {
                int temp = res.key;
                res.key = res.right.key;
                res.right.key = temp;
                res = res.right;
            }
        
        }
        return res;
    }
}

class NodeBasedHeap{
    int size;
    MinHeapNode root = null;

    public void insert(int key){
        size++;
        if (size == 1){
            root = new MinHeapNode(key);
        }
        else {
            MinHeapNode rightMostNodeParent = findRightMostNodeParent();
            MinHeapNode newNode = new MinHeapNode(key);
            if(rightMostNodeParent.left == null){
                rightMostNodeParent.left = newNode;
            }
            else {
                rightMostNodeParent.right = newNode;
            }
            newNode.parent = rightMostNodeParent;

            while (newNode.parent != null && newNode.key < newNode.parent.key){
                int temp = newNode.parent.key;
                newNode.parent.key = newNode.key;
                newNode.key = temp;
                newNode = newNode.parent;
            }
        }

        
    }

    public int deleteMin(){
        if (root == null)
            return 0;
        else if (size == 1){
            size--;
            int res = root.key;
            root = null;
            return res;
        }
        else {
            int res = root.key;

            MinHeapNode rightMostNodeParent = findRightMostNodeParent();

            if(rightMostNodeParent.right == null){
                root.key = rightMostNodeParent.left.key;
                rightMostNodeParent.left = null;
            }
            else {
                root.key = rightMostNodeParent.right.key;
                rightMostNodeParent.right = null;
            }
            size--;

            MinHeapNode current = root;
            while (current.left != null && current.key > current.left.key || 
                current.right != null && current.key > current.right.key){
                if (current.left != null && current.right != null && 
                current.left.key < current.right.key || current.right == null) {
                    int temp = current.key;
                    current.key = current.left.key;
                    current.left.key = temp;
                    current = current.left;
                }
                else {
                    int temp = current.key;
                    current.key = current.right.key;
                    current.right.key = temp;
                    current = current.right;
                }
            
            }
            return res;
        }
    }

    MinHeapNode findRightMostNodeParent(){
        int pos = 1;
        while (pos <= size){
            pos <<= 1;
        }

        pos >>= 2;
        
        MinHeapNode rightMostNodeParent = root;
        while (pos > 1){
            rightMostNodeParent = (size & pos) == 0 ? rightMostNodeParent.left : rightMostNodeParent.right;
            pos >>= 1;
        }
        return rightMostNodeParent;
    }
}

class ArrayBasedHeap{
    private ArrayList<Integer> heap = new ArrayList<>();
    public void insert(int key){
        heap.add(key);
        int pos = heap.size() -1;
        while (pos != 0){
            int parentPos = (pos-1)/2;
            if (heap.get(parentPos) > heap.get(pos)){
                int temp = heap.get(parentPos);
                heap.set(parentPos, heap.get(pos));
                heap.set(pos, temp);
                pos = parentPos;
            }
            else break;
        }
    }

    public int deleteMin(){
        int res = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        int pos = 0;
        while (2 * pos + 1 < heap.size() && heap.get(pos) > heap.get(2 * pos + 1) ||
        2 * pos + 2 < heap.size() && heap.get(pos) > heap.get(2 * pos + 2)){
            if (2 * pos + 1 < heap.size() && 2 * pos + 2 < heap.size()
            && heap.get(2 * pos + 1) < heap.get(2 * pos +2)|| 2 * pos + 2 >= heap.size()){
                int temp = heap.get(pos);
                heap.set(pos, heap.get(2 * pos+1));
                heap.set(2 * pos+1, temp);
                pos = 2 * pos+1;
            }
            else {
                int temp = heap.get(pos);
                heap.set(pos, heap.get(2 * pos+2));
                heap.set(2 * pos+2, temp);
                pos = 2 * pos+2;
            }
        }

        return res;
    }

    public static ArrayBasedHeap heapify(ArrayList<Integer> arr){
        ArrayBasedHeap res = new ArrayBasedHeap();
        res.heap = arr;

        //root-fix

        for (int i = arr.size()-1; i >= 0; i--) {
            int pos = i;
            while (2 * pos + 1 < arr.size() && arr.get(pos) > arr.get(2 * pos + 1) ||
            2 * pos + 2 < arr.size() && arr.get(pos) > arr.get(2 * pos + 2)){
                if (2 * pos + 1 < arr.size() && 2 * pos + 2 < arr.size()
                && arr.get(2 * pos + 1) < arr.get(2 * pos +2)|| 2 * pos + 2 >= arr.size()){
                    int temp = arr.get(pos);
                    arr.set(pos, arr.get(2 * pos+1));
                    arr.set(2 * pos+1, temp);
                    pos = 2 * pos+1;
                }
                else {
                    int temp = arr.get(pos);
                    arr.set(pos, arr.get(2 * pos+2));
                    arr.set(2 * pos+2, temp);
                    pos = 2 * pos+2;
                }
            }
        }
        return res;
    }
}
public class PriorityQueue {
    public static void main(String[] args) {
        // 测试 NodeBasedHeap
        System.out.println("测试 NodeBasedHeap");
        NodeBasedHeap nodeHeap = new NodeBasedHeap();
        nodeHeap.insert(10);
        nodeHeap.insert(20);
        nodeHeap.insert(5);
        nodeHeap.insert(30);
        nodeHeap.insert(15);

        System.out.println("删除最小元素: " + nodeHeap.deleteMin());
        System.out.println("删除最小元素: " + nodeHeap.deleteMin());
        System.out.println("删除最小元素: " + nodeHeap.deleteMin());
        System.out.println("删除最小元素: " + nodeHeap.deleteMin());
        System.out.println("删除最小元素: " + nodeHeap.deleteMin());
        
        // 测试 ArrayBasedHeap
        System.out.println("\n测试 ArrayBasedHeap");
        ArrayBasedHeap arrayHeap = new ArrayBasedHeap();
        arrayHeap.insert(10);
        arrayHeap.insert(20);
        arrayHeap.insert(5);
        arrayHeap.insert(30);
        arrayHeap.insert(15);

        System.out.println("删除最小元素: " + arrayHeap.deleteMin());
        System.out.println("删除最小元素: " + arrayHeap.deleteMin());
        System.out.println("删除最小元素: " + arrayHeap.deleteMin());
        System.out.println("删除最小元素: " + arrayHeap.deleteMin());
        System.out.println("删除最小元素: " + arrayHeap.deleteMin());
    }
    
}
