package test;


public class NumberOfPath_Leet62 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(uniquePaths(5,2));
    }

    //只能向右和向下走有多少种方式走到右下角，解题方式就是回溯和动态规划，回溯很好写，但是时间超标
    //动态规划就是从右下角开始遍历右下角所在的层和列，每个点的路径数为下方路径数量加右边节点路径数量，最右下角的初始为1，
    //为了写代码更简洁，可以申请矩阵的时候多申请一行和列，那样就不用判断每个点是否在边界，都能直接加，嘻嘻嘻
    static public int uniquePaths(int m, int n) {
		/*回溯法超出时间限制
        int i = 1;
        int j = 1;
        int res = 0;
        res = findPath(i, j, m, n);
        return res;
    }

	static public int findPath(int i,int j, int m,int n){
		int num = 0;
		if(i==m&&j==n)
			num = 1;
		if(i<m){
			num += findPath(i+1, j, m, n);
		}
		if(j<n){
			num += findPath(i, j+1, m, n);
		}

		return num;

		*/
        //定义的大一格，代码更方便写,不然还要判断是否在边界
        int[][] count = new int[m+1][n+1];
        int i = m - 1;
        int j = n - 1;
        count[i][j] = 1;
        while(i>=0 && j>=0){
            for(int row=i;row>=0;row--){
                count[row][j] += count[row+1][j] + count[row][j+1];
            }
            for(int col=j-1;col>=0;col--){
                count[i][col] += count[i][col+1] + count[i+1][col];
            }
            i--;
            j--;
        }
		/*
		for(int a=0;a<m;a++){
			for(int b=0;b<n;b++){
				System.out.print(count[a][b]);
			}
			System.out.println("");
		}
		*/
        return count[0][0];
    }
}
