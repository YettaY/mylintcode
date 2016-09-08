package leetcode.Medium;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        //Solution 1:
//        if(nums==null || nums.length==0)
//            return 0;
//        int[] min=new int[nums.length],max=new int[nums.length];
//        int r=nums[0];
//        max[0]=min[0]=nums[0];
//        for(int i=1;i<nums.length;i++){
//            max[i]=Math.max(nums[i], Math.max(nums[i]*max[i-1],nums[i]*min[i-1]));
//            min[i]=Math.min(nums[i], Math.min(nums[i]*max[i-1],nums[i]*min[i-1]));
//            r=Math.max(r, Math.max(min[i],max[i]));
//        }
//        return r;

        //Solution 2:
        if(nums==null || nums.length==0)
            return 0;
        int r=nums[0];
        for(int i=1, max=r, min=r;i<nums.length;i++){
            if(nums[i]<0){
                int t=max;
                max=min;
                min=t;
            }
            max=Math.max(nums[i], max*nums[i]);
            min=Math.min(nums[i], min*nums[i]);
            r=Math.max(r, max);
        }
        return r;
    }
}
