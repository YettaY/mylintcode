package leetcode.Hard;

/**
 * Created by yanglu on 16/8/4.
 * Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 update(3, 2, 2)
 sumRegion(2, 1, 4, 3) -> 10
 * We use colSums[i][j] = the sum of ( matrix[0][j], matrix[1][j], matrix[2][j],......,matrix[i - 1][j] ).
 */
public class Range_Sum_Query_2D_Mutable {
//    class NumMatrix {
//        int[][] colsum, m;
//        public NumMatrix(int[][] matrix) {
//            if (matrix==null || matrix.length==0)
//                return;
//            this.m = matrix;
//            colsum = new int[m.length + 1][m[0].length];
//            for (int i=1;i<colsum.length;i++)
//                for (int j=0;j<colsum[0].length;j++)
//                    colsum[i][j]=colsum[i-1][j]+m[i-1][j];
//        }
//
//        public void update(int row, int col, int val) {
//            for(int i=row+1;i<colsum.length;i++)
//                colsum[i][col]=colsum[i][col]-m[row][col]+val;
//            m[row][col]=val;
//        }
//
//        public int sumRegion(int row1, int col1, int row2, int col2) {
//            int r=0;
//            for(int i=col1;i<=col2;i++)
//                r+=colsum[row2+1][i]-colsum[row1][i];
//            return r;
//        }
//    }


    //Solution 2: binary indexed tree , time should be O(log(m) * log(n))
    class NumMatrix {

        int[][] tree, nums;
        int m,n;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m+1][n+1];
            nums = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    update(i, j, matrix[i][j]);
        }

        public void update(int row, int col, int val) {
            if (m == 0 || n == 0) return;
            int delta = val - nums[row][col];
            nums[row][col] = val;
            for (int i = row + 1; i <= m; i += i & (-i)) {
                for (int j = col + 1; j <= n; j += j & (-j)) {
                    tree[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0) return 0;
            return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
        }

        public int sum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= i & (-i)) {
                for (int j = col; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }

}
