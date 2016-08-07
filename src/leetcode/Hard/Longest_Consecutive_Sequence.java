package leetcode.Hard;
import java.util.*;

/**
 * Created by yanglu on 16/7/23.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
//        Map<Integer,Integer> map=new HashMap<>();
//        int r=0;
//        for(int n:nums){
//            if (!map.containsKey(n)){
//                int left=map.containsKey(n-1)?map.get(n-1):0;
//                int right=map.containsKey(n+1)?map.get(n+1):0;
//                int sum=left+1+right;
//                map.put(n,sum);
//                r=Math.max(r,sum);
//                map.put(n-left,sum);
//                map.put(n+right,sum);
//            }
//        }
//        return r;

        //Solution2: [0,1,1,1,3,4,5]
        Arrays.sort(nums);
        int j=0,offset=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i-1]==nums[i])
                offset++;
            if(i-j-offset == nums[i]-nums[j])
                max=Math.max(max,i-j-offset+1);
            else{
                j=i;
                offset=0;
            }
        }
        return max;

    }
}
