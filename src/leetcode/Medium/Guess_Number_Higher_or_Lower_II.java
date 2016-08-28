package leetcode.Medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * For each number x in range[i~j]
 we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
 --> // the max means whenever you choose a number, the feedback is always bad,
 therefore leads you to a worse branch.
 then we get DP([i~j]) = min{xi, ... ,xj}
 --> // this min makes sure that you are minimizing your cost.
 */
public class Guess_Number_Higher_or_Lower_II {
    public int getMoneyAmount(int n) {
        //Solution1 :O(n^3)
//        int[][] dp=new int[n+1][n+1];
//        for(int len=1;len<n;len++){
//            for (int i=1;i+len<=n;i++){
//                int j=i+len;
//                int min=Integer.MAX_VALUE;
//                for (int k=i;k<j;k++){
//                    int t=k+Math.max(dp[i][k-1], dp[k+1][j]);
//                    min=Math.min(min,t);
//                }
//                dp[i][j]=min;
//            }
//        }
//        return dp[1][n];

        //Solution2: O(n^2)
        //http://artofproblemsolving.com/community/c296841h1273742

//        int[][] f=new int[n+1][n+1];
//        Deque<Integer[]> q;  // item[]{index, value}
//        int a,b,k0,v,f1,f2;
//        for(b=2;b<=n;b++){
//            k0=b-1;
//            q=new LinkedList<Integer[]>();
//            for(a=b-1;a>0;a--){
//                //find k0[a][b] by definition in O(1) time.
//                while(f[a][k0-1] > f[k0+1][b])
//                    k0--;
//                // find f1[a][b] in O(1) time.
//                while(!q.isEmpty() && q.peekFirst()[0]>k0)
//                    q.pollFirst();
//                v=f[a+1][b]+a;
//                while (!q.isEmpty() && q.peekLast()[1]>v)
//                    q.pollLast();
//                q.offer(new Integer[]{a,v});
//                f1=q.peekFirst()[1];
//                f2=f[a][k0]+k0+1;
//                f[a][b]=Math.min(f1,f2);
//            }
//        }
//        return f[1][n];

        //Solution 3: replace deque by idx and val arrays:
        // q.pollFirst()={index[beginIdx], value[beginIdx]},
        // q.pollLast()={index[endIdx], value[endIdx]}, ...

        int[][] f=new int[n+1][n+1];
        int[] id=new int[n+1];
        int[] val=new int[n+1];
        int a,b,k0,v,f1,f2;
        for(b=2;b<=n;b++){
            k0=b-1;
            int s=0, e=-1; // q.isEmpty()==(s>e)
            for(a=b-1;a>0;a--){
                //find k0[a][b] by definition in O(1) time.
                while(f[a][k0-1] > f[k0+1][b])
                    k0--;
                // find f1[a][b] in O(1) time.
                while(s<=e && id[s]>k0)
                    s++;
                v=f[a+1][b]+a;
                while (s<=e && val[e]>v)
                    e--;
                e++;
                id[e]=a;
                val[e]=v;

                f1=val[s];
                f2=f[a][k0]+k0+1;
                f[a][b]=Math.min(f1,f2);
            }
        }
        return f[1][n];
    }
}
