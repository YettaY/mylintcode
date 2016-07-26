package leetcode.Medium;

/**
 * Given any n, we make a guess k. Then we break the interval [1,n] into [1,k - 1] and [k + 1,n]. The min of worst case cost can be calculated recursively as
 cost[1,n] = k + max{cost[1,k - 1] , cost[k+1,n]}
 Also, it takes a while for me to wrap my head around "min of max cost".
 My understand is that: you strategy is the best, but your luck is the worst.
 You only guess right when there is no possibilities to guess wrong.
 */
public class Guess_Number_Higher_or_Lower_II {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int len=1;len<n;len++){
            for (int i=1;i+len<=n;i++){
                int j=i+len;
                int min=Integer.MAX_VALUE;
                for (int k=i;k<j;k++){
                    int t=k+Math.max(dp[i][k-1], dp[k+1][j]);
                    min=Math.min(min,t);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n];
    }
}
