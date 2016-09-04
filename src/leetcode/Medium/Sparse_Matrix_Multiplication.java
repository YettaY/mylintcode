package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/8/29.
 */
public class Sparse_Matrix_Multiplication {
    class node{
        private int x,y;
        public node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {

        //Solution 1: TLE
//        int[][] r=new int[A.length][B[0].length];
//        for(int i=0;i<A.length;i++){
//            for(int j=0;j<B[0].length;j++){
//                int ans=0;
//                for(int k=0;k<A[0].length;k++)
//                    ans+=A[i][k]*B[k][j];
//                r[i][j]=ans;
//            }
//        }
//        return r;

        // Solution 2: 0(N^3)
//        int[][] r=new int[A.length][B[0].length];
//        for(int i=0;i<A.length;i++){
//            for(int k=0;k<A[0].length;k++){
//                if(A[i][k]!=0) {
//                    for (int j = 0; j < B[0].length; j++)
//                        r[i][j] += A[i][k] * B[k][j];
//                }
//            }
//        }
//        return r;

        //Solution 3:
        int[][] r=new int[A.length][B[0].length];
        List<node> la=new ArrayList<>(), lb=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]!=0)
                    la.add(new node(i,j));
            }
        }
        for(int i=0;i<B.length;i++){
            for(int j=0;j<B[0].length;j++){
                if(B[i][j]!=0)
                    lb.add(new node(i,j));
            }
        }
        for(node na:la){
            for(node nb:lb){
                if(na.y==nb.x)
                    r[na.x][nb.y]+=A[na.x][na.y]*B[nb.x][nb.y];
            }
        }
        return r;
    }
}
