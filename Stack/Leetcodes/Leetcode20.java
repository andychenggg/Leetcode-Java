package Stack.Leetcodes;

import java.util.ArrayDeque;



class Solution {
    public boolean isValid(String s) {
        char []  charArr = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char i: charArr){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else if(stack.peek() == '[' && i == ']' ||
            stack.peek() == '{' && i == '}' ||
            stack.peek() == '(' && i == ')'){
                stack.pop();
            }
            else {
                stack.push(i);
            }
        }
        return stack.isEmpty();
    }
}