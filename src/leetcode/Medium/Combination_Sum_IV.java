package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/7/27.
 */
public class Combination_Sum_IV {
    static Map<Integer, Integer> map=new HashMap<>();
    public static int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length==0 || target<0)
            return 0;

        //Solution1:DP
//        int[] dp=new int[target+1];
//        dp[0]=1;
//        for (int i=1;i<=target;i++){
//            for(int n:nums){
//                if (i>=n)
//                    dp[i]+=dp[i-n];
//            }
//        }
//        return dp[target];

        //Solution2:recursion TLE
//        if(target==0)
//            return 1;
//        int r=0;
//        for(int n:nums)
//            if(target>=n)
//                r+=combinationSum4(nums, target-n);
//        return r;

        //Solution2: optimized recursion
        if (target==0)
            return 1;
        if (map.containsKey(target))
            return map.get(target);
        int r=0;
        for (int n:nums)
            if (target>=n)
                r+=combinationSum4(nums, target-n);
        map.put(target, r);
        return r;

    }

    public static void main(String[] args){
        int[] n={1, 2, 3};
        System.out.println(combinationSum4(n,4));
    }
}

      //follow-up: allow negative integers


//    Map<Integer, Map<Integer,Integer>> map2 = new HashMap<>();
//    private int helper2(int[] nums, int len, int target, int MaxLen) {
//        int count = 0;
//        if (  len > MaxLen  ) return 0;
//        if ( map2.containsKey(target) && map2.get(target).containsKey(len)) {
//            return map2.get(target).get(len);
//        }
//        if ( target == 0 )   count++;
//        for (int num: nums) {
//            count+= helper2(nums, len+1, target-num, MaxLen);
//        }
//        if ( ! map2.containsKey(target) ) map2.put(target, new HashMap<Integer,Integer>());
//        Map<Integer,Integer> mem = map2.get(target);
//        mem.put(len, count);
//        return count;
//    }
//
//    public int combinationSum42(int[] nums, int target, int MaxLen) {
//        if (nums == null || nums.length ==0 || MaxLen <= 0 ) return 0;
//        map2 = new HashMap<>();
//        return helper2(nums, 0,target, MaxLen);
//    }