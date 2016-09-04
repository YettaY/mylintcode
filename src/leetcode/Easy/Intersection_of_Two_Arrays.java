package leetcode.Easy;
import java.util.*;
/**
 * Created by Administrator on 2016/8/23.
 */
public class Intersection_of_Two_Arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length*nums2.length==0)
            return new int[0];
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums2);
        for(int i=0;i<nums1.length;i++){
            if(isexist(nums2,nums1[i]))
                set.add(nums1[i]);
        }
        int i=0;
        int[] r=new int[set.size()];
        for(int e:set)
            r[i++]=e;
        return r;
    }
    public static boolean isexist(int[] n, int e){
        int i=0, j=n.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(n[m]==e)
                return true;
            if(n[m]<e)
                i=m+1;
            else
                j=m-1;
        }
        return false;
    }
    public static void main(String[] args){
        int[] n1={4,7,9,7,6,7}, n2={5,0,0,6,1,6,2,2,4};
        int[] r=intersection(n1,n2);
        for(int i=0;i<r.length;i++)
            System.out.print(r[i]+" ");
    }
}
