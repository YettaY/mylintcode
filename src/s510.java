import java.util.*;
/**
 * Created by Administrator on 2016/6/3.
 */
public class s510 {
    public static int maximalRectangle(boolean[][] matrix) {
        if (matrix==null || matrix.length==0)
            return 0;
        int[][] h=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (i==0){
                    if (matrix[0][j]==true)
                        h[0][j]=1;
                }
                else{
                    if (matrix[i][j]!=false)
                        h[i][j]=h[i-1][j]+1;
                }
            }
        }

        for (int i=0;i<matrix.length;i++){
            Stack<Integer> s=new Stack<>();
            int j=0;
            while(j<=h[0].length){
                if (s.isEmpty() || (j<h[0].length && h[i][j]>=h[i][s.peek()])){
                    s.push(j);
                    j++;
                }
                else{
                    int height=h[i][s.pop()];
                    int wide=s.isEmpty()?j:j-s.peek()-1;
                    max=Math.max(max,height*wide);
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        boolean[][] matrix={
                {true,true,false,false,true},
                {false,true,false,false,true},
                {false,false,true,true,true},
                {false,false,true,true,true},
                {false,false,false,false,true}};
        System.out.println(maximalRectangle(matrix));
    }
}
