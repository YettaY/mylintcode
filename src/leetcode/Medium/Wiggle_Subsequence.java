package leetcode.Medium;

import google.Array;

import java.util.Arrays;

/**
 * Created by yanglu on 16/7/24.
 */
public class Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
//        int up=1,down=1;
//        for(int i=1;i<nums.length;i++){
//            if (nums[i]>nums[i-1])
//                up=down+1;
//            else if (nums[i]<nums[i-1])
//                down=up+1;
//        }
//        return Math.min(nums.length, Math.max(up, down));

        //Solution2:
        if(nums==null || nums.length==0)
            return 0;
        int[] up=new int[nums.length], down=new int[nums.length];
        Arrays.fill(up,1);
        Arrays.fill(down,1);
        for(int i=1; i<nums.length; ++i){
            for(int j=0; j<i; ++j){
                if(nums[j]<nums[i]){
                    up[i]=Math.max(up[i], down[j]+1);
                }
                else if(nums[j]>nums[i]){
                    down[i]=Math.max(down[i], up[j]+1);
                }
            }
        }
        return Math.max(up[nums.length-1], down[nums.length-1]);
    }
}
