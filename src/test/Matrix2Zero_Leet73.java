package test;

public class Matrix2Zero_Leet73 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
    //将一个矩阵中为0的所在列和行所有元素都设置为0
    //空间复杂度为常数个，思路就是先变行在编列，但是这样变了之后就不知道原来那些列是不需要变得
    //因此先扫描一次，找到第一个全不为0的行来做标志行，如果哪一列有0对应的将该行的对应位置变0，然后变完行之后变列时以这个作参考
    static public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int temp = -1;
        for(int i=0;i<row;i++){
            int flag=0;
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    flag = 1;
                    break;
                }
            }
            //找到第一个不存在0的行
            if(flag == 0){
                temp = i;
                break;
            }
        }
        //每行都有0，意思就是全部要变成0
        if(temp == -1){
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++)
                    matrix[i][j] = 0;
            }
        }else{
            for(int j=0;j<col;j++){
                //这一列有0了，不需要在判断，
                if(matrix[temp][j] == 0)
                    continue;
                for(int i=0;i<row;i++){
                    if(matrix[i][j] == 0){
                        matrix[temp][j] = 0;
                        break;
                    }
                }
            }
            //行置0
            for(int i=0;i<row;i++){
                if(i==temp)
                    continue;
                int flag = 0;
                for(int j=0;j<col;j++){
                    if(matrix[i][j] == 0){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    for(int j=0;j<col;j++)
                        matrix[i][j] = 0;
                }
            }
            //列置0
            for(int j=0;j<col;j++){
                if(matrix[temp][j] != 0)
                    continue;
                for(int i=0;i<row;i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
