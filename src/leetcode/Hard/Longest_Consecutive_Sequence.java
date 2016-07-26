package leetcode.Hard;
import java.util.*;

/**
 * Created by yanglu on 16/7/23.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int r=0;
        for(int n:nums){
            if (!map.containsKey(n)){
                int left=map.containsKey(n-1)?map.get(n-1):0;
                int right=map.containsKey(n+1)?map.get(n+1):0;
                int sum=left+1+right;
                map.put(n,sum);
                r=Math.max(r,sum);
                map.put(n-left,sum);
                map.put(n+right,sum);
            }
        }
        return r;
    }
}
