package leetcode.Hard;

import java.util.*;

/**
 * Created by Administrator on 2016/7/5.
 */
public class Russian_Doll_Envelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0)
            return 0;

        //Solution1:
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0]!=o2[0])
//                    return o1[0]-o2[0];
//                return o1[1]-o2[1];
//            }
//        });

//        int[] d=new int[envelopes.length];
//        d[0]=1;
//        int max=1;
//        for (int i=1;i<envelopes.length;i++){
//            d[i]=1;
//            for (int j=0;j<i;j++){
//                if (envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1])
//                    d[i]=Math.max(d[j]+1,d[i]);
//            }
//            max=Math.max(max, d[i]);
//        }
//        return max;


        //Solution2:
        //先对宽度进行排序，再应用最长递增子序列的方法，寻找高度递增的最大长度。
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0])
                    return o1[0]-o2[0];
                return o2[1]-o1[1];
            }
        });
        int len = 0;
        int[] h = new int[envelopes.length];
        for(int[] envelope : envelopes) {
            int i=0, j=len-1;
            while (i<=j) {
                int m = (i+j)/2;
                if (h[m] < envelope[1])
                    i=m+1;
                else
                    j=m-1;
            }
            h[i] = envelope[1];
            if (i == len)
                len ++;
        }
        return len;
    }
    public static void main(String[] args){
        int[][] e={{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        int[][] e1={{30,50},{12,2},{3,4},{12,15}};
        int[][] e2={{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(e2));
    }
}
