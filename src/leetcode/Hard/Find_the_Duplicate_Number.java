package leetcode.Hard;

/**
 * Created by Administrator on 2016/9/1.
 */
public class Find_the_Duplicate_Number {
    // Solution 1: O(NlogN)
//    public int findDuplicate(int[] nums) {
//        int i=0, j=nums.length-1;
//        while(i<j){
//            int m=(i+j)/2,c=0;
//            for(int k=0;k<nums.length;k++)
//                if(nums[k]<=m)
//                    c++;
//            if(c<=m)
//                i=m+1;
//            else
//                j=m;
//        }
//        return i;
//    }

    //Solution 2: 时间，空间都是O(N)
//    public int findDuplicate(int[] nums) {
//        int[] c=new int[nums.length+1];
//        for(int i=0;i<nums.length;i++)
//            c[nums[i]]++;
//        for(int i=0;i<c.length;i++)
//            if(c[i]>1)
//                return i;
//        return 0;
//    }

    //Solution 3: 将下标和数值形成链表，重复值一定是环的入口
    public int findDuplicate(int[] nums) {
        int slow=nums[0], fast=nums[nums[0]],entry=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=nums[slow];
        while(entry!=slow){
            entry=nums[entry];
            slow=nums[slow];
        }
        return entry;
    }
}
