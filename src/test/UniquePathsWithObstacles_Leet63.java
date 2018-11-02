package test;


/**
 * 很简单的动态规划寻找路径问题呀
 */
public class UniquePathsWithObstacles_Leet63 {

    public static void main(String[] args){

        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0 ,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int col = obstacleGrid.length;
        int row = obstacleGrid[0].length;
        //多一行一列方便直接计算
        int[][] nums = new int[col + 1][row + 1];
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j < nums[0].length; j++){
                //开始点如果没障碍就是有1中方法到达，其实可以优化成有障碍就退出的,无所谓了
                if(i == 1 && j == 1 && obstacleGrid[0][0] != 1){
                    nums[i][j] = 1;
                    continue;
                }
                if(obstacleGrid[i - 1][j - 1] == 1){
                    continue;
                }
                nums[i][j] = ((i > 1 && obstacleGrid[i - 2][j - 1] == 1) ? 0 : nums[i - 1][j])
                        + ((j > 1 && obstacleGrid[i - 1][j - 2] == 1) ? 0 : nums[i][j - 1]);
            }
        }


        return nums[col][row];
    }
}
