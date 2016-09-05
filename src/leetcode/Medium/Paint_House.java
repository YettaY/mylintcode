package leetcode.Medium;

/**
 * Created by Administrator on 2016/9/4.
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.
 */
public class Paint_House {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;
        int n=costs.length;
        // Solution 1:
//        int[][] dp=new int[n][3];
//        for(int i=0;i<3;i++)
//            dp[0][i]=costs[0][i];
//        for(int i=1;i<n;i++){
//            for(int j=0;j<3;j++){
//                int min=Integer.MAX_VALUE;
//                for(int k=0;k<3;k++)
//                    min = (k==j) ? min : Math.min(min, dp[i-1][k]);
//                dp[i][j]=costs[i][j]+min;
//            }
//        }
//        int r=Integer.MAX_VALUE;
//        for(int i=0;i<3;i++)
//            r=Math.min(r, dp[n-1][i]);
//        return r;

        //Solution 2:
//        int min1=0, min2=0, idmin1=-1;
//        for(int i=0;i<n;i++){
//            int m1=Integer.MAX_VALUE, m2=m1, idm1=-1;
//            for(int j=0;j<3;j++){
//                int cost=costs[i][j] + (j==idmin1 ? min2 : min1);
//                if(cost<m1){
//                    m2=m1;
//                    m1=cost;
//                    idm1=j;
//                }
//                else if(cost<m2)
//                    m2=cost;
//            }
//            min1=m1;
//            min2=m2;
//            idmin1=idm1;
//        }
//        return min1;

        //Solution 3:
        for(int i=1;i<n;i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }
}
