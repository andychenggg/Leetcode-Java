package Tree.Implementations;

import java.util.ArrayDeque;

public class Calculator {
    public int calculateByStacks(String s){
        s = "("+s+")";
        char [] expression = s.toCharArray();

        ArrayDeque <Integer> numStack = new ArrayDeque<>();
        ArrayDeque <Character> operatorStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length; i++) {
            if(expression[i] == '('){
                operatorStack.push(expression[i]);
            }
            else if(expression[i] == '+' || expression[i] == '*' ||expression[i] == '/'){
                if(!operatorStack.isEmpty() && priorOrEquiTo(operatorStack.peek(), expression[i])){
                    char operator = operatorStack.pop();
                    int operant2 = numStack.pop(), operant1 = numStack.pop();
                    int out = cal(operant1, operant2, operator);
                    numStack.push(out);
                }
                operatorStack.push(expression[i]);
            }
            else if(expression[i] == '-'){
                if(!operatorStack.isEmpty() && priorOrEquiTo(operatorStack.peek(), expression[i])){
                    char operator = operatorStack.pop();
                    int operant2 = numStack.pop(), operant1 = numStack.pop();
                    int out = cal(operant1, operant2, operator);
                    numStack.push(out);
                }
                numStack.push(-1);
                operatorStack.push('+');
                operatorStack.push('*');
            }
            else if(expression[i] == ')'){
                while(operatorStack.peek() != '('){
                    char operator = operatorStack.pop();
                    int operant2 = numStack.pop(), operant1 = numStack.pop();
                    int out = cal(operant1, operant2, operator);
                    numStack.push(out);

                }
                operatorStack.pop(); // '('
            }
            else {
                StringBuilder temp = new StringBuilder();
                while(i < expression.length && expression[i] <= '9' && expression[i] >= '0'){
                    temp.append(expression[i++]);
                }
                i--;
                numStack.push(Integer.parseInt(temp.toString()));
            }

        }
        return numStack.pop();
    }

    public int cal(int op1, int op2, char operator){
        switch (operator) {
            case '+': return op1+op2;
            case '*': return op1*op2;
            case '/': return op1/op2;
            default:
                throw new IllegalArgumentException("operator: "+operator);
        }
    }

    public boolean priorOrEquiTo(char op1, char op2){
        switch (op2) {
            case '+':
            case '-':
                if(op1 != '(') return true;
                return false;
            case '*':
            case '/':
                if(op1 == '*' || op1 == '/') return true;
                return false;
        
            default:
                throw new IllegalArgumentException("operator: "+op1+" " +op2);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        // 测试样例
        String[] testCases = {
            "1+2+3",           // 简单加法: 6
            "10-5",            // 减法: 5
            "2*3*4",           // 连续乘法: 24
            "8/4/2",           // 连续除法: 1
            "2+3*4",           // 混合优先级: 14
            "8/4+2",           // 除法加法: 4
            "(1+2)*3",         // 带括号: 9
            "9/(3/3)",         // 嵌套除法: 9
            "1+(2+3)*(4+5)",   // 复杂表达式: 46
            "10-5-3"           // 连续减法: 2
        };
        
        // 预期结果
        int[] expectedResults = {6, 5, 24, 1, 14, 4, 9, 9, 46, 2};
        
        // 执行测试
        for (int i = 0; i < testCases.length; i++) {
            if(i == 9){
                System.out.println("");
            }
            String expression = testCases[i];
            int result = calculator.calculateByStacks(expression);
            int expected = expectedResults[i];
            
            System.out.println("表达式: " + expression);
            System.out.println("计算结果: " + result);
            System.out.println("预期结果: " + expected);
            System.out.println("测试 " + (i + 1) + ": " + (result == expected ? "通过" : "失败"));
            System.out.println("-------------------");
        }
    }
}
