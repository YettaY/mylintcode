import java.util.*;

public class s548 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int[0];

        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j])
                i++;
            else if (nums1[i]>nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;j++;
            }
        }
        int[] r=new int[list.size()];
        i=0;
        for (int e:list)
            r[i++]=e;
        return r;
    }
}
