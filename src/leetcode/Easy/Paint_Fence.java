package leetcode.Easy;

/**
 * Created by yanglu on 16/8/7.
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note:
 n and k are non-negative integers.

 Given an 'n', there are two kinds of color combinations.

 The last two colors are the same, which is denoted as same in my code.
 The last two colors are different, which is denoted as diff in my code.
 Now consider 'n+1' and its two kinds of solutions.

 Regarding case 1, the new same equals the old diff, right? Otherwise, there would be three adjacent walls with the same color.
 Regarding case 2, all old combinations with length 'n' are legally combined with one of remaining (k-1) colors.
 So the update formula is

 same(n + 1) = diff(n)
 diff(n + 1) = (same(n) + diff(n)) * (k - 1)
 As no need to keep all history of same and diff, so the space complexity is O(1). The code is as follows.


 */
public class Paint_Fence {
    public int numWays(int n, int k) {
//        if(n==0 || k==0 || (k==1 && n>=3))
//            return 0;
//        if(n==1)
//            return k;
//        if(n==2)
//            return k*k;
//        int same=k, diff=k*(k-1);
//        for(int i=3;i<=n;i++){
//            int nsame=diff;
//            int ndiff=(same+diff)*(k-1);
//            same=nsame;
//            diff=ndiff;
//        }
//        return diff+same;


        //Solution 2:
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];
        // diff[i] means the ith post has a different color with the (i-1)th post.
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            same[i] = diff[i-1];
            diff[i] = (k - 1) * same[i-1] + (k - 1) * diff[i-1];
        }
        return same[n-1] + diff[n-1];
    }
}
