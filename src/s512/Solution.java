package s512;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Solution {
    public int numDecodings(String s) {
        // Write your code here
        int[] dp=new int[s.length()+1];
        if (s==null || s.length()==0)
            return 0;
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;
        for (int i=2;i<=s.length();i++){
            if (s.charAt(i-1)!='0')
                dp[i]=dp[i-1];
            int t=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
            if (t>=10 && t<=26)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }
}
