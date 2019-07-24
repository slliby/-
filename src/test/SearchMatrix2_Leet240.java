package test;

/**
 * 二维数组查找2，主要找到规律，就是每行的终点，比他大的只可能在他下面，比他小的只可能在他左边，但是其实还可以二分查找，来加快速度
 * @author wangjiaping
 * @date 2019-04-16
 */
public class SearchMatrix2_Leet240 {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        int i = 0;
        int j = col - 1;
        while ((i < row) && (j >= 0)) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }
}
