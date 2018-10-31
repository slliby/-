package test;

/**
 * 很简单的思路，不想提了
 */
public class MaxIncreaseKeepingSkyLine_Leet807 {

    public static void main(String[] args){

        int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid){
        int col = grid.length;
        int row = grid[0].length;
        int[] m = new int[col];
        int[] n = new int[row];
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                m[i] = m[i] > grid[i][j] ? m[i] : grid[i][j];
                n[j] = n[j] > grid[i][j] ? n[j] : grid[i][j];
            }
        }
        int sum = 0;

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                sum += Math.min(m[i], n[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
