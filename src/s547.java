import java.util.*;

/**
 * Created by Administrator on 2016/6/3.
 */
public class s547 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int[0];
        Set<Integer> set1=new HashSet<>(), set2=new HashSet<>();
        for (int e:nums1)
            if (!set1.contains(e))
                set1.add(e);
        for (int e:nums2)
            if (set1.contains(e))
                set2.add(e);
        int[] r=new int[set2.size()];
        int i=0;
        for (int e:set2)
            r[i++]=e;
        return r;
    }
}
