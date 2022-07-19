public class Solution62_01 {
    public int uniquePaths(int m, int n) {
        // matrix[m-1, n-1] 终点
        // matrix[m-1-1, n-1] m-1-1 >= 0
        // matrix[m-1, n-1-1] n-1-1 >= 0
        // matrix[m-1, n-1] = matrix[m-1, n-1-1] + matrix[m-1-1, n-1] m-1-1
        int colIndex = m;
        int rowIndex = n;
        int matrix[][] = new int[m][n];
        for (int i = 0; i < rowIndex; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 0; i < colIndex; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 1; i < colIndex; i++) {
            for (int j = 1; j < rowIndex; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        // matrix[m-1, n-1] = matrix[m-1, n-1-1] + matrix[m-1-1, n-1];
        return matrix[m - 1][n - 1];
    }
}
