package leetcode.Hard;

/**
 * Created by yanglu on 16/10/4.
 * 思路是再不看M的情况下，最终结果的取值范围是[最大的元素，所有元素之和]，然后就是用二分在这个范围里找。

 注意二分的取舍要配合取舍方程，我用的方程是，保证子集的和都小于等于二分测试的那个二分M，然后集合数小于要求的m。一旦子集数量超过m，说明我们测试的二分M太小了，弄大点，才能让每个子集多放点元素，从而使得总子集数不超过m.

 所以返还失败的情况下 L = M + 1
 返还成功并不代表就是解，它仅仅表示当前二分M可以使得分出的子集数不超过m，所以R=M作为候选，这样最后判断失败保留的R就是最后一次成功的判断。
 */
public class Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int m) {
        long max=0, sum=0;
        for(int n:nums){
            if(max<n) max=n;
            sum+=n;
        }
        return (int)binarysearch(nums, m, max, sum);
    }
    public long binarysearch(int[] nums, int m, long l, long r){
        while(l<r){
            long mid=(l+r)/2;
            if(valid(nums, m, mid))
                r=mid;
            else
                l=mid+1;
        }
        return r;
    }
    public boolean valid(int[] nums, int m, long mid){
        long sum=0;
        int count=1;
        for(int n:nums){
            if(sum+n<=mid)
                sum+=n;
            else {
                count++;
                sum=n;
                if(count>m)
                    return false;
            }
        }
        return true;
    }
}
