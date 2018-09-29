package test;

import java.util.ArrayList;
import java.util.List;


public class GenerateBrackets_Leet22 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> l = generateParenthesis(3);
        for(int i=0;i<l.size();i++)
            System.out.println(l.get(i));
    }
    //生成括号问题，回溯算法，我的思路是创建一个方法，参数包括总共需要对数，当前已有对数，左括号总有数，左括号还能匹配数
    //跳出条件就是需要对数和当前已有对数相同，否则如果左括号还能匹配数为0，那么下一次递归就必须是插入左括号
    //如果不为0，同时左括号总数到达需要对数了，那么就只能插入右括号
    //否则就插入左右括号都行，都递归
    static public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();

        String nowString = "";
        int number = 0;
        int leftNum = 0;
        int totalLeftNum = 0;
        getBrackets(l, nowString, n, number, leftNum,totalLeftNum);

        return l;

    }

    static public void getBrackets(List<String> l,String nowString,int n,int number,int leftNum,int totalLeftNum){
        //先写退出条件
        if(number == n){
            //为0说明要求长度就是0，不需要插入
            if(nowString.length() != 0){
                l.add(nowString);
            }
            return;
        }
        if(leftNum == 0){
            String nextString = nowString + "(";
            getBrackets(l, nextString, n, number, leftNum+1,totalLeftNum+1);
        }else if(totalLeftNum == n){
            String nextString = nowString + ")";
            getBrackets(l, nextString, n, number+1, leftNum-1, totalLeftNum);
        }else{
            String nextString1 = nowString + "(";
            String nextString2 = nowString + ")";
            getBrackets(l, nextString1, n, number, leftNum+1, totalLeftNum+1);
            getBrackets(l, nextString2, n, number+1, leftNum-1, totalLeftNum);
        }
    }

}
