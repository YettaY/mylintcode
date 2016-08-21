package leetcode.Medium;

/**
 * Created by yanglu on 16/7/24.
 */
public class Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        int up=1,down=1;
        for(int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1])
                up=down+1;
            else if (nums[i]<nums[i-1])
                down=up+1;
        }
        return Math.min(nums.length, Math.max(up, down));




        /*
        * int size=nums.size();
        if(size==0) return 0;
        vector<int> f(size, 1);
        vector<int> d(size, 1);
        for(int i=1; i<size; ++i){
            for(int j=0; j<i; ++j){
                if(nums[j]<nums[i]){
                    f[i]=max(f[i], d[j]+1);
                }
                else if(nums[j]>nums[i]){
                    d[i]=max(d[i], f[j]+1);
                }
            }
        }
        return max(d.back(), f.back());*/
    }
}
