package leetcode.Medium;

import java.util.*;

/**
 * Created by Administrator on 2016/8/29.
 */
public class Coin_Change {
    // Solution 1: dp O(N^2)
//    public int coinChange(int[] coins, int amount) {
//        int[] dp=new int[amount+1];
//        for(int i=1;i<=amount;i++){
//            int min=Integer.MAX_VALUE;
//            for(int c:coins){
//                if(i>=c && dp[i-c]!=-1){
//                    min=Math.min(min, dp[i-c]+1);
//                }
//            }
//            dp[i] = min==Integer.MAX_VALUE ? -1 : min;
//        }
//        return dp[amount];
//    }

    //Soltuion 2: recursion  O(N^C)
    Map<Integer, Integer> map=new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        if(map.containsKey(amount))
            return map.get(amount);
        int min=amount+1;
        for(int c:coins){
            int cur=0;
            if(amount>=c){
                int next=coinChange(coins, amount-c);
                if(next>=0)
                    cur=next+1;
            }
            if(cur>0)
                min=Math.min(min, cur);
        }
        int ans= (min==amount+1)?-1:min;
        map.put(amount, ans);
        return ans;
    }
}
