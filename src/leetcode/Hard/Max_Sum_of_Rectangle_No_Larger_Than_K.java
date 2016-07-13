package leetcode.Hard;

import java.util.Stack;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix==null || matrix.length==0)
            return 0;
        int[][] area=new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                int cur=matrix[i][j];
                if (i-1>=0)
                    cur+=area[i-1][j];
                if (j-1>=0)
                    cur+=area[i][j-1];
                if (i-1>=0 && j-1>=0)
                    cur-=area[i-1][j-1];
                area[i][j]=cur;
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i=0;i<matrix.length;i++){
           for (int j=0;j<matrix[0].length;j++){
               for (int r=i;i<matrix.length;r++){
                   for (int c=j;c<matrix[0].length;c++){
                       int cur=area[r][c];
                       if (i-1>=0)
                           cur-=area[i-1][c];
                       if (j-1>=0)
                           cur-=area[r][j-1];
                       if (i-1>=0 && j-1>=0)
                           cur+=area[i-1][j-1];
                       if (cur<=k)
                           max=Math.max(max,cur);
                   }
               }
           }
        }
        return max;
    }
    public static void main(String[] args){
        int[][] m={{2,2,-1}};
        System.out.println(maxSumSubmatrix(m,3));
    }
}
