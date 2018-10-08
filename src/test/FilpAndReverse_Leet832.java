package test;

/*
反转图像，很简单了，所谓的先水平翻转再把0变为1，把1变为0可以看出是不冲突的
那么很简单可以一起执行，翻转就是交换，1和0互换其实可以通过和1异或得到，
那么就是把当前点的值设为对称点和1的异或值，注意要奇数列那个中间点怎么处理
 */
public class FilpAndReverse_Leet832 {

    public static void main(String[] args){

        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        A = flipAndInvertImage(A);


    }

    public static int[][] flipAndInvertImage(int[][] A){
        int col = A.length;
        int row = A[0].length;
        int x,y;
        for(int i=0;i<col;i++){
            int j = 0;
            for(j=0;j<row/2;j++){
                x = A[i][j];
                y = A[i][row - j - 1];
                A[i][j] = y ^ 1;
                A[i][row - j - 1] = x ^ 1;
            }
            if(row % 2 == 1){
                A[i][j] ^= 1;
            }
        }

        return A;
    }
}
