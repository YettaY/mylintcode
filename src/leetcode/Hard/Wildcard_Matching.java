package leetcode.Hard;

/**
 * Created by yanglu on 16/7/23.
 */
public class Wildcard_Matching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int j=1;j<=p.length();j++){
            if(p.charAt(j-1)=='*')
                dp[0][j]=true;
            else
                break;
        }


        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='?' || p.charAt(j-1)==s.charAt(i-1))
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j]=dp[i-1][j-1] || dp[i-1][j]||dp[i][j-1];
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args){
        System.out.println(isMatch("aa","a*a"));
    }
}
