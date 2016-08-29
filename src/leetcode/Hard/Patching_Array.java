package leetcode.Hard;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Patching_Array {
    public static int minPatches(int[] nums, int n) {
        long sum=1;
        int r=0;
        for(int i=0;sum<=n;){
            if(i<nums.length&& sum>=nums[i])
                sum+=nums[i++];
            else
            {
                sum+=sum;
                r++;
            }
        }
        System.out.println(sum);
        return r;
    }
    public static void main(String[] args){
        int[] n=new int[0];//1,2,4,8  范围[1,16)
        System.out.println(minPatches(n,8));
    }
}
