package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/8/28.
 */
public class Maximum_Size_Subarray_Sum_Equals_k {
    public static int maxSubArrayLen(int[] nums, int k) {
        //Solution 1: O(n^2)
//        if (nums==null || nums.length==0)
//            return 0;
//        int max=0, sum = 0;
//        for (int i = 0; i < nums.length; ++i)
//        {
//            sum = nums[i];
//            if (sum == k)
//                max = Math.max(max, 1);
//            for (int j = i + 1; j < nums.length; ++j)
//            {
//                sum += nums[j];
//                if (sum == k)
//                    max = Math.max(max, j - i + 1);
//            }
//        }
//        return max;
        //Solution 2: O(n) The HashMap stores the sum of all elements before index i as key, and i as value.
        // For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k, and update max length.
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0,max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k)
                max=i+1;
            else if(map.containsKey(sum-k))
                max= Math.max(max, i-map.get(sum-k));
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
    public static void main(String[] args){
        int[] n={-2, -1, 2, 1};
        System.out.println(maxSubArrayLen(n,1));
    }
}
