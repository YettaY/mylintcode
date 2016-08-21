package leetcode.Medium;
import java.util.*;
/**
 * Created by yanglu on 16/8/6.
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 For example, given nums = [-2, 0, 1, 3], and target = 2.
 Return 2. Because there are two triplets which sums are less than 2:
 [-2, 0, 1]
 [-2, 0, 3]
 */
public class ThreeSum_Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        Arrays.sort(nums);
        int r=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]*3>=target)
                break;   // follow up
            int left=i+1, right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[i]+nums[right];
                if(sum>=target)
                    right--;
                else {
                    r+=(right-left);
                    left++;
                }
            }
            StringBuilder sb=new StringBuilder();
            String ss=sb.substring(i)+"(";
        }
        return r;
    }
}
