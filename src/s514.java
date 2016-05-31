/**
 * Created by Administrator on 2016/5/26.
 */
/*
Solution1:time: O(n), space: O(n)
这里是只允许两个连续的fence时同样的颜色，所以对于dp[i]而言，其状态不仅与dp[i-1]有关，也与dp[i-2]有关。
我们可以分两种情况考虑，一种是当前fence颜色与上个fence颜色不同，一种是当前fence颜色与上个fence颜色相同。
对于前者，显然dp[i] = (k - 1) * dp[i - 1]。
对于后者，由于题目要求不能连续三个fence颜色相同，我们只要保证上上个fence与当前fence颜色不同即可，
此时dp[i] = 1 * (k - 1) * dp[i - 2]。
所以 dp[i] = (k - 1) * dp[i - 1] + (k - 1) * dp[i - 2]
另外，这道题也可以有Follow up比如题目改成最多允许3个fence有相同颜色，结果怎么样？
用上面类似的分析，可得
dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1) * 1 + dp[i - 3] * (k - 1) * 1 * 1

Solution2:时间 O(N) 空间 O(1) 滚动数组
不能有超过连续两根柱子是一个颜色，也就意味着第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色。
如果不是同一个颜色，计算可能性的时候就要去掉之前的颜色，也就是k-1种可能性。
假设dp[1]是第一根柱子及之前涂色的可能性数量，dp[2]是第二根柱子及之前涂色的可能性数量，
则dp[3]=(k-1)*dp[1] + (k-1)*dp[2]。
所有柱子中第一根涂色的方式有k中，第二根涂色的方式则是k*k，因为第二根柱子可以和第一根一样。

Solution3:时间 O(N) 空间 O(1)*/
public class s514 {
    public int numWays(int n, int k) {
        // Solution1
//        if (n<=1)
//            return n*k;
//        int[] dp=new int[n];
//        dp[0]=k;
//        dp[1]=k*(k-1)+k;
//        for (int i=2;i<n;i++)
//            dp[i]=dp[i-1]*(k-1)+dp[i-2]*(k-1);
//        return dp[n-1];

        //Solution2
//        int[] dp={0,k,k*k,0};
//        if (n<=2)
//            return dp[n];
//        for (int i=2;i<n;i++){
//            dp[3]=(k-1)*(dp[1]+dp[2]);
//            dp[1]=dp[2];
//            dp[2]=dp[3];
//        }
//        return dp[3];

        //Solution3
        if (n<=1)
            return n*k;
        int s1=k,s2=k*k,s3=0;
        if (n==2)
            return s2;
        for (int i=2;i<n;i++){
            s3=(k-1)*(s1+s2);
            s1=s2;
            s2=s3;
        }
        return s3;
    }
}
