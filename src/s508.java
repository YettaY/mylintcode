//507 508都可以用第一种方法做O(nlgn)
//208还可以用第二种方法做O(n)
import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/3.
 */
public class s508 {
    public static void wiggleSort(int[] nums) {
        //Solution1
//        if (nums==null || nums.length<2)
//            return;
//        Arrays.sort(nums);
//        int[] t=new int[nums.length];
//        int mid=(nums.length+1)/2,end=nums.length;
//        for (int i=0;i<t.length;i++){
//            if (i%2==0)
//                t[i]=nums[--mid];
//            else
//                t[i]=nums[--end];
//        }
//        for (int i=0;i<t.length;i++)
//            nums[i]=t[i];


        //Solution2
        for (int i=1;i<nums.length;i++){
            if ((i%2==0 && nums[i]>nums[i-1]) || (i%2==1 && nums[i]<nums[i-1])){
                int t=nums[i-1];
                nums[i-1]=nums[i];
                nums[i]=t;
            }
        }
    }
    public static void main(String[] args){
        int[] nums={3,5,2,1,6,4};
        wiggleSort(nums);
    }
}
