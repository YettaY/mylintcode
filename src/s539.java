/**
 * Created by Administrator on 2016/6/3.
 */
public class s539 {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=0)
                nums[j++]=nums[i];
        }
        while(j<nums.length)
            nums[j++]=0;
    }
}
