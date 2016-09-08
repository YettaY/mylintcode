package leetcode.Hard;

import google.Array;

import java.util.Arrays;

/**
 * Created by yanglu on 16/9/7.
 * 用一个二维数组ans[][]表示到每个格子时，勇士到每一步时至少需要的魔力，
 * 如ans[i][j]表示勇士在[i, j]处至少需要ans[i][j]魔力才能到达[m, n]救出皇后。
 * 在从左上角到右下角的路径中不能让骑士的血量低于0，所以我们要找的不是走到最后剩余血量最多的那一条路径，而是路径上的最小值最大的那一条。因为路径中还有正数，所以正向处理起来感觉比较麻烦，可以考虑逆向处理，从右下角像左上角处理，dp[i][j]表示从坐标(i, j)到右下角所需的血量。初始化时假设最后剩余血里为0，而

 状态转移方程：

 dungeon[i][j] = max(min(dungeon[i][j+1], dungeon[i+1][j])-dungeon[i][j], 0)
 */
public class Dungeon_Game {
    public int calculateMinimumHP(int[][] dungeon) {
        //Solution 1:
//        if(dungeon==null || dungeon.length==0)
//            return 0;
//        int m=dungeon.length, n=dungeon[0].length;
//        int[][] a=new int[m][n];
//        a[m-1][n-1]=dungeon[m-1][n-1]<0?-dungeon[m-1][n-1]:0;
//        for(int i=m-2;i>=0;i--)
//            a[i][n-1]=a[i+1][n-1] >= dungeon[i][n-1] ? a[i+1][n-1]-dungeon[i][n-1]: 0;
//        for(int i=n-2;i>=0;i--)
//            a[m-1][i]=a[m-1][i+1] >= dungeon[m-1][i] ? a[m-1][i+1]-dungeon[m-1][i]: 0;
//        for(int i=m-2;i>=0;i--){
//            for(int j=n-2;j>=0;j--){
//                int down = a[i+1][j]>=dungeon[i][j] ? a[i+1][j]-dungeon[i][j]:0;
//                int right = a[i][j+1]>=dungeon[i][j] ? a[i][j+1]-dungeon[i][j]:0;
//                a[i][j]=Math.min(down, right);
//            }
//        }
//        return a[0][0]+1;

        //Solution 2:
//        int m=dungeon.length, n=dungeon[0].length;
//        int[] dp=new int[n+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[n-1]=1;
//        for(int i=m-1;i>=0;i--){
//            for(int j=n-1;j>=0;j--){
//                dp[j]=Math.max(1, Math.min(dp[j],dp[j+1])-dungeon[i][j]);
//            }
//        }
//        return dp[0];

        //Solution 3:
        int m=dungeon.length, n=dungeon[0].length;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int t=Integer.MAX_VALUE;
                if(j<n-1)
                    t=dungeon[i][j+1];
                if(i<m-1)
                    t=Math.min(dungeon[i+1][j], t);
                dungeon[i][j]=Math.max(1, (t==Integer.MAX_VALUE ? 1:t) - dungeon[i][j]);
            }
        }
        return dungeon[0][0];
    }
}
