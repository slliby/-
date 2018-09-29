package test;

public class RepeatedString_Leet686 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*
     * 简单的思路，就是不断拼接，直到超过B的长度为止再做一次，因为最多可能首尾都要补齐
     */
    static public int repeatedStringMatch(String A, String B) {
        int time = B.length() / A.length();
        String p = "";
        for(int i=0;i<time;i++) {
            p += A;
        }
        int last = time + 2;
        while(time <= last) {
            if(p.contains(B))
                return time;
            p += A;
            time++;
        }
        return -1;
    }

}
