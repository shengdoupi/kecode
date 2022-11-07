package matrix.lc73;

/**
 * @author zhouke <zhouke1998301@sjtu.edu.cn>
 * Created on 2022-11-05
 */
public class SetMatrixZerosTwo {
    /**
     * 空间复杂度O(1)的解法，使用原矩阵的第一行和第一列进行辅助标记，同时使用两个标记变量对第一行和第一列的初始情况进行标记；
     * 时间：O(n * m)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < n; ++i) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int j = 0; j < m; ++j) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < m; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            for (int j = 0; j < m; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < n; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
