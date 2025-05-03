package Tree.Implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuffmanEncoding {
    private class Node {
        boolean isLeafNode;
        char c;
        int freq;
        Node left, right;
        Node(boolean isLeafNode, char c, int freq){
            this.isLeafNode = isLeafNode;
            this.c = c;
            this.freq = freq;
        }
        Node mergeNodes(Node n2){
            Node res = new Node(false, '0', this.freq+n2.freq);
            res.left = this;
            res.right = n2;
            return res;
        }
        public int getFreq(){return freq;}
    }
    public Node buildHuffmanTree(HashMap<Character, Integer> frequency){
        List<Node> freList = new ArrayList<>();
        frequency.entrySet().forEach(
            e -> freList.add(new Node(true, e.getKey(), e.getValue()))
        );
        freList.sort(Comparator.comparing(e -> e.getFreq()));
        while (true) {
            if(freList.size() < 2) break;
            Node n1 = freList.remove(0), n2 = freList.remove(0);
            Node fatherNode = n1.mergeNodes(n2);
            int position = 0;
            while(position < freList.size() && freList.get(position).getFreq() < fatherNode.getFreq()) position++;
            freList.add(position, fatherNode);
        }
        return freList.get(0);

    }

    public HashMap<Character, String> setEncodeMap(Node root){
        HashMap<Character, String> res = new HashMap<>();
        traversal(root, "", res);
        return res;
    }
    public void traversal(Node root, String sequence, HashMap<Character, String> encodeMap){
        if(root.isLeafNode){
            encodeMap.put(root.c, sequence);
            return;
        }
        
        traversal(root.left, sequence+"0", encodeMap);
        traversal(root.right, sequence+"1", encodeMap);
        
    }

    public static void main(String[] args) {
        // 创建频率表
        HashMap<Character, Integer> frequency = new HashMap<>();
        frequency.put('A', 15);
        frequency.put('B', 7);
        frequency.put('C', 6);
        frequency.put('D', 12);
        frequency.put('E', 4);
        frequency.put('F', 8);
        
        HuffmanEncoding huffman = new HuffmanEncoding();
        
        // 构建哈夫曼树
        Node root = huffman.buildHuffmanTree(frequency);
        
        // 获取编码映射
        HashMap<Character, String> encodingMap = huffman.setEncodeMap(root);
        
        // 打印每个字符的编码
        System.out.println("字符编码映射：");
        for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 计算总位数
        int totalBits = 0;
        for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
            char c = entry.getKey();
            String code = entry.getValue();
            int charFreq = frequency.get(c);
            totalBits += charFreq * code.length();
            System.out.println(c + ": " + charFreq + " × " + code.length() + " = " + (charFreq * code.length()) + "位");
        }
        
        System.out.println("\n哈夫曼编码总位数: " + totalBits);
        
        // 计算固定长度编码所需位数
        int totalChars = frequency.values().stream().mapToInt(Integer::intValue).sum();
        int fixedLengthBits = totalChars * 3; // 3位固定长度编码
        
        System.out.println("固定长度编码总位数: " + fixedLengthBits);
        System.out.println("节省位数: " + (fixedLengthBits - totalBits));
        System.out.println("效率提升: " + String.format("%.1f%%", (fixedLengthBits - totalBits) * 100.0 / fixedLengthBits));
        
        // 验证编码是否符合前缀码特性
        boolean isPrefixCode = true;
        for (String code1 : encodingMap.values()) {
            for (String code2 : encodingMap.values()) {
                if (!code1.equals(code2) && (code1.startsWith(code2) || code2.startsWith(code1))) {
                    isPrefixCode = false;
                    break;
                }
            }
        }
        System.out.println("\n是否是前缀码: " + isPrefixCode);
    }

}
