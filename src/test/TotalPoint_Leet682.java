package test;

import java.util.Stack;


/*
棒球比赛，其实就是一个不断操作前面数字的过程，很简单的可以想到使用栈来做这个操作
 */
public class TotalPoint_Leet682 {

    public static void main(String[] args){

        String[] ops = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops){
        Stack<Integer> s = new Stack<>();
        int res = 0;

        char c;
        String temp;
        for(int i=0;i<ops.length;i++){
            int flag = 1;
            temp = ops[i];
            if(temp.charAt(0) == '-') {
                flag = -1;
                temp = temp.substring(1);
            }
            if(temp.charAt(0) >= '0' && temp.charAt(0) <= '9'){
                int num = 0;
                for(int j=0;j<temp.length();j++){
                    c = temp.charAt(j);
                    if(c >= '0' && c <= '9'){
                        num = num * 10 + c - '0';
                    }
                }
                num *= flag;
                s.push(num);
            }else if(temp.charAt(0) == 'C'){
                s.pop();
            }else if(temp.charAt(0) == 'D'){
                int a = s.pop();
                s.push(a);
                s.push(a * 2);
            }else if(temp.charAt(0) == '+'){
                int a = s.pop();
                int b = s.pop();
                s.push(b);
                s.push(a);
                s.push(a + b);
            }

        }
        while(s.size() > 0){
            res += s.pop();
        }

        return res;
    }
}
