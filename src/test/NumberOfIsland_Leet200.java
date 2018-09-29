package test;


public class NumberOfIsland_Leet200 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
    //岛屿个数，很简单的回溯算法了，没意思
    static public int numIslands(char[][] grid) {
        int num = 0;
        if(grid.length==0 || grid[0].length==0)
            return 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !flag[i][j]){
                    num++;
                    flag[i][j] = true;
                    setFlag(grid, flag, i, j);
                }
            }
        }

        return num;
    }

    static public void setFlag(char[][] grid,boolean[][] flag,int row,int col){
        if(row>0 && !flag[row-1][col] && grid[row-1][col]=='1'){
            flag[row-1][col] = true;
            setFlag(grid, flag, row-1, col);
        }
        if(col>0 && !flag[row][col-1] && grid[row][col-1]=='1'){
            flag[row][col-1] = true;
            setFlag(grid, flag, row, col-1);
        }
        if(row<grid.length-1 && !flag[row+1][col] && grid[row+1][col]=='1'){
            flag[row+1][col] = true;
            setFlag(grid, flag, row+1, col);
        }
        if(col<grid[0].length-1 && !flag[row][col+1] && grid[row][col+1]=='1'){
            flag[row][col+1] = true;
            setFlag(grid, flag, row, col+1);
        }
    }

}

