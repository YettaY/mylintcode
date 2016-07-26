package leetcode.Medium;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 1.DP o(n*n)
 * 2.By considering each number as a node and its multiples as connected nodes.
 * We can obtain a DAG. For example, [1,3,4,6] can form a DAG with edges of 1->3, 1->4, 1->6, 3->6.
 * So, the answer is the longest path of 1->3->6.
 *The optimal solution should be O(|E|+|V|). We know |V|=N. However, we have to go through N^2 comparisons to get |E|. I
 * n this solution, I use the idea of generating multiples of each V_1 to find all of its edges (V1, V2) s.t. V2 % V1 = 0.
 * This generation is upward bounded by the V_max which is the max value in the given array.
 * The while loop runs V_max/V1 times and could be very large if V_max is large.
 * Therefore, by indexing the given array, the unnecessary loops can be reduced and this indexing costs logN.
 * Thus, the while loop ends up runs min( V_max/V1, N_v) = C, where N_v is the number of V greater than V1.
 * As a result, the overall complexity is NCLogN, where C <= (N+(N-1)+(N-2)+(N-3)+...)/N
 and C <= (V_max/V1+V_max/V2+V_max/V3+V_max/V4+...)/N.
 Therefore, if N is small, the running time is close to NN since C is close to N and logN is very small.
 When, N is very large, C should be bounded by V_max/N which is considered as constant so that the running time is close to NlogN.
 */
public class Largest_Divisible_Subset {

    int[] maxLen; // whether got visited if yes store its max length
    int[] path; // remember the path of max length trace
    int len;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        //Solution 1:
        List<Integer> r=new ArrayList<>();
        if (nums==null || nums.length==0)
            return r;
        int[] dp=new int[nums.length];
        int[] pre=new int[nums.length];
        Arrays.fill(pre,-1);
        Arrays.sort(nums);
        int start=0, max=0;
        for (int i=0;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i]=dp[j]+1;
                    pre[i]=j;
                    if (dp[i]>=max){
                        max=dp[i];
                        start=i;
                    }
                }
            }
        }
        while(start!=-1){
            r.add(nums[start]);
            start=pre[start];
        }
        return r;

        //Solution 2：
//        List<Integer> ret = new ArrayList();
//        if (nums==null || nums.length ==0) return ret;
//        len = nums.length;
//        if (len == 1) {
//            ret.add(nums[0]);
//            return ret;
//        }
//        maxLen = new int[len];
//        path = new int[len];
//        int max = 0;
//        int idx = -1;
//        Arrays.sort(nums);
//        for (int i=0; i<len; i++) {
//            int temp = helper( i, nums);
//            if (temp > max ) {
//                max = temp;
//                idx = i;
//            }
//        }
//        while (idx != path[idx]) {
//            ret.add(nums[idx]);
//            idx = path[idx];
//        }
//        ret.add(nums[idx]);
//        return ret;
    }

    public int helper(int cur, int[] nums) {
        if (cur > len ) return 0;
        if ( maxLen[cur] > 0 ) return maxLen[cur];
        path[cur] = cur;
        int curMax = 0;
        long curVal = (long)nums[cur];
        long i=2; // factor for next multiple
        long next = curVal * i; // next multiple
        int nid = cur+1;
        // teminated when next mulitiple is out of range or it is the last one
        while ( next <= (long) nums[len-1] && nid < len ) {
            if ( nums[nid] < next ) {
                // call binary search only when the next value is smaller than next multiple
                // and find the ceiling value of the multiple
                nid = Arrays.binarySearch(nums, nid+1, len, (int)next );
                if (nid < 0) nid = -(nid+1);
            } else {
                // the ceiling value is a multiple
                if ( nums[nid] % nums[cur] == 0 ) {
                    int temp = helper(nid, nums);
                    if (temp > curMax ) {
                        curMax = temp;
                        path[cur] = nid;
                    }
                }
                // increase the factor for next multiple
                i= (nums[nid]/nums[cur])+1;
                next = curVal * i;
            }
        }
        maxLen[cur] = curMax+1;
        return maxLen[cur];
    }
}
