package test;

/*
学生出勤记录第一题。。。emmm不想解释
编程基础题了，hello world级别
 */
public class CheckRecord_551 {

    public static void main(String[] args){

        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s){

        int len = s.length();
        int aNum = 0;
        int lNum = 1;
        char c;
        for(int i=0;i<len;i++){
            c = s.charAt(i);
            if(c == 'A')
                aNum++;
            else if(c == 'L'){
                if(i>0 && s.charAt(i - 1) == 'L')
                    lNum++;
                else
                    lNum = 1;
            }

            if(aNum > 1 || lNum > 2)
                return false;
        }

        return true;
    }
}
