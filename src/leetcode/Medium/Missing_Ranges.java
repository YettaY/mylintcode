package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/4.
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Missing_Ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> r=new ArrayList<String>();
        for(int i=0;i<=nums.length;i++){
            int s=i==0?lower:nums[i-1]+1;
            int e=i==nums.length?upper:nums[i]-1;
            if(s==e)
                r.add(""+s);
            else if(s<e)
                r.add(s+"->"+e);
        }
        return r;
    }
}
