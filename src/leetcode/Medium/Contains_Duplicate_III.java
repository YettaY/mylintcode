package leetcode.Medium;
import java.util.*;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Solution 1:
//        if(t<0 || k<1 || nums==null || nums.length==0)
//            return false;
//        SortedSet<Long> set=new TreeSet<Long>();
//        for(int i=0;i<nums.length;i++){
//            if(!set.subSet((long)nums[i]-t,(long)nums[i]+t+1).isEmpty())
//                return true;
//            if(i>=k)
//                set.remove((long)(nums[i-k]));
//            set.add((long)nums[i]);
//        }
//        return false;

        //Solution 2:
        /*
The idea is like the bucket sort algorithm. Suppose we have consecutive buckets covering the range of nums with each bucket a width of (t+1). If there are two item with difference <= t, one of the two will happen:
(1) the two in the same bucket
(2) the two in neighbor buckets*/
        if(t<0 || k<1|| nums==null || nums.length==0)
            return false;
        Map<Long, Long> map=new HashMap<>();
        long w=(long)t+1;
        for(int i=0;i<nums.length;i++){
            long m=getid(nums[i], w);
            if(map.containsKey(m))
                return true;
            if(map.containsKey(m-1) && Math.abs(map.get(m-1)-nums[i]) <w)
                return true;
            if(map.containsKey(m+1) && Math.abs(map.get(m+1)-nums[i]) <w)
                return true;
            map.put(m, (long)nums[i]);
            if(i>=k)
                map.remove(getid(nums[i-k], w));
        }
        return false;
    }
    public long getid(long i, long w){
        return i<0 ? (i+1)/w-1 : i/w;
    }
}
