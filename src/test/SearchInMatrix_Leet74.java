package test;

/**
 * 二维矩阵查找,很easy了，注意边界情况，优化的话可以考虑二分
 * @author wangjiaping
 * @date 2019-04-16
 */
public class SearchInMatrix_Leet74 {

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
        for (i = row - 1; i >= 0; i--) {
            if (matrix[i][col - 1] < target) {
                break;
            }
        }
        if (i < (row - 1)) {
            i++;
            int begin = 0;
            int end = col - 1;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
        }


        return false;
    }
}
