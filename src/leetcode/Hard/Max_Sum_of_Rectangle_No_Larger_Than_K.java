package leetcode.Hard;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Administrator on 2016/7/13.
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
//        if (matrix==null || matrix.length==0)
//            return 0;
//        int[][] area=new int[matrix.length][matrix[0].length];
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++){
//                int cur=matrix[i][j];
//                if (i-1>=0)
//                    cur += area[i-1][j];
//                if (j-1>=0)
//                    cur += area[i][j-1];
//                if (i-1>=0 && j-1>=0)
//                    cur -= area[i-1][j-1];
//                area[i][j]=cur;
//            }
//        }
//        int max=Integer.MIN_VALUE;

        //Solution1:O((MN)^2)
//        for (int i=0;i<matrix.length;i++){
//           for (int j=0;j<matrix[0].length;j++){
//               for (int r=i;r<matrix.length;r++){
//                   for (int c=j;c<matrix[0].length;c++){
//                       int cur=area[r][c];
//                       if (i-1>=0)
//                           cur -= area[i-1][c];
//                       if (j-1>=0)
//                           cur -= area[r][j-1];
//                       if (i-1 >= 0 && j-1 >= 0)
//                           cur += area[i-1][j-1];
//                       if (cur <= k)
//                           max=Math.max(max,cur);
//                   }
//               }
//           }
//        }

        //Solution2:o(n^3lgn)
//        for (int i=0;i<matrix.length;i++){
//            for (int j=i;j<matrix.length;j++){
//                TreeSet<Integer> tree=new TreeSet<Integer>();
//                tree.add(0);
//                for (int c=0;c<matrix[0].length;c++){
//                    int cur=area[j][c];
//                    if (i-1>=0)
//                        cur -= area[i-1][c];
//                    Integer ceiling=tree.ceiling(cur-k);
//                    if (ceiling!=null)
//                        max=Math.max(max,cur-ceiling);
//                    tree.add(cur);
//                }
//            }
//        }
//        return max;

        //Solution 3: n^2*mlogm
        long[] sum=new long[matrix.length+1];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            long[] rowsum=new long[matrix.length];
            for(int j=i;j<matrix[0].length;j++){
                for(int p=0;p<matrix.length;p++){
                    rowsum[p]+=matrix[p][j];
                    sum[p+1]=sum[p]+rowsum[p];
                }
                max=Math.max(max,mergesort(sum,0,sum.length,k));
                if(max==k)
                    return k;
            }
        }
        return max;
    }
    public static int mergesort(long[] sum,int s,int e,int k){
        if(e==s+1)
            return Integer.MIN_VALUE;
        int mid=s+(e-s)/2, cnt=0;
        int r=mergesort(sum,s,mid,k);
        if (r==k)
            return k;
        r=Math.max(r,mergesort(sum,mid,e,k));
        if(r==k)
            return k;
        long[] cache=new long[e-s];
        for(int i=s,j=mid,t=mid;i<mid;i++){
            while(j<e && sum[j]-sum[i]<=k)
                j++;
            if(j-1>=mid){
                r=Math.max(r,(int)(sum[j-1]-sum[i]));
                if(r==k)
                    return k;
            }
            while(t<e && sum[t]<sum[i])
                cache[cnt++]=sum[t++];
            cache[cnt++]=sum[i];
        }
        System.arraycopy(cache,0,sum,s,cnt);
        return r;
    }
    public static void main(String[] args){
        int[][] m={{2,2,-1}};
        System.out.println(maxSumSubmatrix(m,3));
    }
}
