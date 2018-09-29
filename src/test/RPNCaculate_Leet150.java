package test;

import java.util.Stack;

/*
 *  逆波兰表达式，就是后缀表达式求结果，很简单了
 *  用栈，数字就入栈，运算符就出栈两个计算再入栈，xixixi
 */
public class RPNCaculate_Leet150 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] tokens = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    static public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<len;i++) {
            String now = tokens[i];
            switch (now) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-":
                    s.push(-1 * s.pop() + s.pop());
                    break;
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                case "/":
                    int a = s.pop();
                    s.push(s.pop() / a);
                    break;
                default:
                    int res = 0;
                    int flag = 1;
                    for(int j=0;j<now.length();j++) {
                        if(now.charAt(j) == '-') {
                            flag = -1;
                            continue;
                        }
                        res = res * 10 + now.charAt(j) - '0';
                    }
                    s.push(res * flag);
                    break;
            }
        }

        return s.pop();
    }

}
