package Tree.Implementations.Expressions;

import java.util.ArrayDeque;

public class CalculatePrefixExpression {
    public static int calPre(String s){
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                numStack.push(s.charAt(i)-'0');
            }
            else if (s.charAt(i) == ')'){
                i--;
                StringBuilder temp = new StringBuilder();
                while (s.charAt(i) != '('){
                    temp.append(s.charAt(i--));
                }
                numStack.push(Integer.parseInt(temp.reverse().toString()));
            }
            else {
                numStack.push(cal(numStack.pop(), numStack.pop(), s.charAt(i)));
            }
        }
        return numStack.pop();
    }

    public static int cal(int op1, int op2, char operator){
        switch (operator) {
            case '+': return op1+op2;
            case '-': return op1-op2;
            case '*': return op1*op2;
            case '/': return op1/op2;
            default:
                throw new IllegalArgumentException("operator: "+operator);
        }
    }

    public static void main(String[] args) {
        // 测试样例
        String[] testCases = {
            "+3(12)",           // 3+12=15
            "-(25)4",           // 25-4=21
            "*2(15)",           // 2*15=30
            "/(42)6",           // 42/6=7
            "+*(12)34",         // 12*3+4=40
            "-+(50)(23)3",      // 50+23-3=70
            "/*(24)3(10)",      // 24*3/10=7
            "-*+(10)(20)(30)4", // (10+20)*30-4=896
            "+*-(80)(40)3(25)", // (80-40)*3+25=145
            "/+*(15)3(10)+(12)(34)" // (15*3+10)/(12+34)=1
        };
        
        // 预期结果
        int[] expectedResults = {15, 21, 30, 7, 40, 70, 7, 896, 145, 1};
        
        // 执行测试
        for (int i = 0; i < testCases.length; i++) {
            String expression = testCases[i];
            try {
                int result = calPre(expression);
                int expected = expectedResults[i];
                
                System.out.println("表达式: " + expression);
                System.out.println("计算结果: " + result);
                System.out.println("预期结果: " + expected);
                System.out.println("测试 " + (i + 1) + ": " + (result == expected ? "通过" : "失败"));
            } catch (Exception e) {
                System.out.println("表达式: " + expression);
                System.out.println("计算出错: " + e.getMessage());
                System.out.println("测试 " + (i + 1) + ": 失败");
            }
            System.out.println("-------------------");
        }
    }

}
