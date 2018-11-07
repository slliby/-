package test;


/**
 * 下降最小路径和，最简单的动态规划了
 */
public class MinFallingPathSum_Leet931 {

    public static void main(String[] args){

    }

    public static int minFallingPathSum(int[][] A){
        int row = A.length;
        int col = A[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                A[i][j] += Math.min(Math.min(j == 0 ? Integer.MAX_VALUE : A[i - 1][j - 1], A[i - 1][j]), j == col - 1 ? Integer.MAX_VALUE : A[i - 1][j + 1]);
            }
        }

        for(int j = 0; j < col; j++){
            min = Math.min(min, A[row - 1][j]);
        }
        return min;
    }
}
