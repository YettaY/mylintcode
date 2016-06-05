package s513;

/**
 * Created by Administrator on 2016/5/30.
 */
import java.util.*;
public class Solution {
    public int numSquares(int n) {
        // Write your code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i=0;i*i<=n;i++)
            dp[i*i]=1;
        for (int a=0;a<=n;a++){
            for (int b=0;a+b*b<=n;b++)
                dp[a+b*b]=Math.min(dp[a+b*b],dp[a]+1);
        }
        return dp[n];
    }
}
