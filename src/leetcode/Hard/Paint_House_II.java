package leetcode.Hard;

/**
 * Created by Administrator on 2016/9/4.
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Follow up:
 Could you solve it in O(nk) runtime?

 */
public class Paint_House_II {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;
        int n=costs.length, k=costs[0].length;
        //Solution 1: O(nk^2)
//        int[][] dp=new int[n][k];
//        for(int i=0;i<k;i++)
//            dp[0][i]=costs[0][i];
//        for(int i=1;i<n;i++){
//            for(int j=0;j<k;j++){
//                int min=Integer.MAX_VALUE;
//                for(int t=0;t<k;t++){
//                    min =(t==j) ? min : Math.min(min, dp[i-1][t]);
//                }
//                dp[i][j]=min + costs[i][j];
//            }
//        }
//        int r=Integer.MAX_VALUE;
//        for(int i=0;i<k;i++)
//            r= (r>dp[n-1][i]) ? dp[n-1][i] : r;
//        return r;

        //Solution 2: O(nk)
        /*
 If there's no constraint, we choose min cost for each house
 Since no same colors for adjacent houses, just select 2nd min cost color for i - 1
 Current row only relies on last row to: (1) Get current min1, min2 (2) Avoid same color
 So O(1) space is enough*/

        int min1=0, min2=0, idmin1=-1;
        for(int i=0;i<n;i++){
            int m1=Integer.MAX_VALUE, m2=m1, idm1=-1;
            for(int j=0;j<k;j++){
                int cost= costs[i][j]+( (j==idmin1) ? min2:min1 );
                if(cost<m1){
                    m2=m1;
                    m1=cost;
                    idm1=j;
                }
                else if(cost<m2)
                    m2=cost;
            }
            min1=m1;
            min2=m2;
            idmin1=idm1;
        }
        return min1;
    }
}
