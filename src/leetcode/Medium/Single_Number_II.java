package leetcode.Medium;

/**
 * Created by Administrator on 2016/10/9.
 */
public class Single_Number_II {
    public int singleNumber(int[] nums) {

        // Solution 1:
//        if(nums==null)
//            return 0;
//        int[] bit=new int[32];
//        int res=0;
//        for(int i=0;i<32;i++){
//            for(int j=0;j<nums.length;j++)
//                bit[i]+=(nums[j]>>i)&1;
//            res|=(bit[i]%3)<<i;//左移相当于乘以二，右移相当于除以二
//        }
//        return res;

        //Solution 2：
//        if(nums==null)
//            return 0;
//        int res=0;
//        for(int i=0;i<32;i++){
//            int sum=0;
//            for(int n:nums){
//               if((n>>i&1)==1)
//                   sum++;
//            }
//            if(sum%3!=0)
//                res|=(sum%3)<<i;//左移相当于乘以二，右移相当于除以二
//        }
//        return res;

        //Solution 3:
        int one=0, two=0, three=0;
        for(int n:nums){
            two |= (one & n);
            one ^= n;
            three = two & one;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
