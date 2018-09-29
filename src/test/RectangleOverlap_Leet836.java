package test;


public class RectangleOverlap_Leet836 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //判断两个矩形是否重叠,很简单的思路就是一个的最右不能在另一个的左边，最左不能再右边，最上不能在下面，最下不能在最上面
    //然后边界重合不算，加个等于号，ok
    static public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11 = rec1[0];
        int y11 = rec1[1];
        int x12 = rec1[2];
        int y12 = rec1[3];

        int x21 = rec2[0];
        int y21 = rec2[1];
        int x22 = rec2[2];
        int y22 = rec2[3];
        if(x11>x22 || x12<x21 || y11>y22 || y12<y21)
            return false;


        return true;
    }

}
