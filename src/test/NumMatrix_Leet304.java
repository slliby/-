package test;

/**
 * 和数组一样，只不过把记录数组由一维变成了二维而已啦
 */
public class NumMatrix_Leet304 {
    int[][] sums;

    public NumMatrix_Leet304(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return;
        }
        int col = matrix[0].length;
        if(col == 0){
            return;
        }
        sums = new int[row + 1][col + 1];
        for(int i = 1; i < row + 1; i++){
            for(int j = 1; j < col + 1; j++){
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] + matrix[i - 1][j - 1] - sums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row1][col2 + 1] - sums[row2 + 1][col1];
    }

    public static void main(String[] args){
        NumMatrix_Leet304 test = new NumMatrix_Leet304(new int[][]{{3, 0, 2, 1, 4},
                                                    {5, 6, 3, 2, 1},
                                                    {1, 2, 0, 1,5},
                                                    {4, 1, 0 ,1 ,7},
                                                    {1, 0 ,3, 0, 5}});
        //
        System.out.println(test.sumRegion(2, 1, 4, 3));
        System.out.println(test.sumRegion(1, 1, 2, 2));
        System.out.println(test.sumRegion(1, 2, 2, 4));
    }
}
