import java.util.HashMap;
import java.util.Map;

public class CodeTop2 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        // 1 2 1 3 2 4 1 3 4
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    
}
/**
 * CodeTop2, Leetcode146. 
 * https://leetcode.cn/problems/lru-cache/
 */
class LRUCache {
    private class Node{
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        static void insertNodeBehind(Node node, Node behindNode){
            // behindNode is not in linkedlist initially
            Node pre = node;
            Node post = node.next;
            pre.next = behindNode;
            behindNode.pre = pre;
            post.pre = behindNode;
            behindNode.next = post;
        }
        static void removeNode(Node node){
            Node pre = node.pre;
            Node post = node.next;
            pre.next = post;
            post.pre = pre;
        }
    }

    private int capacity;
    private Map<Integer, Node> cacheMap;
    private Node head, tail;

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node cur = cacheMap.get(key);
            Node.removeNode(cur);
            Node.insertNodeBehind(head, cur);
            return cur.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node cur = cacheMap.get(key);
            cur.val = value;
            Node.removeNode(cur);
            Node.insertNodeBehind(head, cur);

        }
        else if (cacheMap.size() < capacity){
            Node cur = new Node(key, value);
            cacheMap.put(key, cur);
            Node.insertNodeBehind(head, cur);

        }
        else {
            // LRU: remove the least recently used node
            cacheMap.remove(tail.pre.key);
            Node.removeNode(tail.pre);
            // add a new Node
            Node cur = new Node(key, value);
            cacheMap.put(key, cur);
            Node.insertNodeBehind(head, cur);

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */