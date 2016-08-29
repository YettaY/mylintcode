package leetcode.Medium;

/**
 * Created by yanglu on 16/8/27.
 */
public class Counting_Bits {
    public int[] countBits(int num) {
//        int[] dp=new int[num+1];
//        for(int i=1;i<=num;i++)
//            dp[i]=dp[i>>1]+(i&1);
//        return dp;


        // Solution 2: i&(i-1) 是吧 i二进制表示的最低位1改为0
        int[] dp=new int[num+1];
        for(int i=1;i<=num;i++)
            dp[i] = dp[i&(i-1)] + 1;
        return dp;
    }
}
