package setmatrixzeros;

/**
 * @author zhouke <zhouke1998301@sjtu.edu.cn>
 * Created on 2022-11-04
 */
public class SetMatrixZeros {

        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            boolean[] rows = new boolean[n];
            boolean[] cols = new boolean[m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (matrix[i][j] == 0) {
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (rows[i] || cols[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    
}
