package Stack.Leetcodes;

import java.util.ArrayDeque;

public class Leetcode394 {
    
}
class Solution {
    public String decodeString(String s) {
        char [] arr = s.toCharArray();
        ArrayDeque <Character> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ']') {
                q.push(arr[i]);
            }
            else {
                StringBuilder temp = new StringBuilder();
                while(q.peek() != '['){
                    temp.append(q.pop());
                }
                q.pop();

                StringBuilder cof = new StringBuilder();
                while(!q.isEmpty() && q.peek() <= '9' && q.peek() >= '0'){
                    cof.append(q.pop());
                }
                int times = Integer.parseInt(cof.reverse().toString());
                for (int j = 0; j < times; j++) {
                    for (int j2 = temp.length() - 1; j2 >= 0; j2--) {
                        q.push(temp.charAt(j2));
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) res.append(q.pop());
        return res.reverse().toString();
    }
}