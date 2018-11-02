package test;

public class MinPathSum_Leet64 {

    public static void main(String[] args){

        //int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = new int[][]{{1, 2}, {5, 6}, {1, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid){
        int col = grid.length;
        int row = grid[0].length;
        int[][] step = new int[col][row];
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(i == 0 && j == 0){
                    step[i][j] = grid[i][j];
                }else if(i == 0){
                    step[i][j] = step[i][j - 1] + grid[i][j];
                }else if(j == 0){
                    step[i][j] = step[i - 1][j] + grid[i][j];
                }else {
                    step[i][j] = Math.min(step[i - 1][j], step[i][j - 1]) + grid[i][j];
                }
            }
        }

        return step[col - 1][row - 1];
    }
}
