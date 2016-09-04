package leetcode.Hard;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
/**
 * Created by Administrator on 2016/8/29.
 * The basic idea is to do merge sort to nums[]. To record the result, we need to keep the index of each number in the original array. So instead of sort the number in nums, we sort the indexes of each number.
 Example: nums = [5,2,6,1], indexes = [0,1,2,3]
 After sort: indexes = [3,1,0,2]

 While doing the merge part, say that we are merging left[] and right[], left[] and right[] are already sorted.
 We keep a rightcount to record how many numbers from right[] we have added and keep an array count[] to record the result.
 When we move a number from right[] into the new sorted array, we increase rightcount by 1.
 When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.
 */
public class Count_of_Smaller_Numbers_After_Self {
    int[] c;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> r=new ArrayList<>();
        c=new int[nums.length];
        int[] id=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            id[i]=i;
        sort(nums, id, 0, nums.length-1);
        for(int i=0;i<nums.length;i++)
            r.add(c[i]);
        return r;
    }
    private void sort(int[] n, int[] id, int s, int e){
        if(s>=e)
            return ;
        int m=(s+e)/2;
        sort(n, id, s, m);
        sort(n, id, m+1,e);
        merge(n ,id, s, m, e);
    }
    private void merge(int[] n, int[] id, int s, int m, int e){
        int l=s, r=m+1, rc=0, nid=0;
        int[] newid=new int[e-s+1];
        while(l<=m && r<=e){
            if(n[id[r]] < n[id[l]]){
                newid[nid++]=id[r++];
                rc++;
            }
            else{
                newid[nid++]=id[l];
                c[id[l]] += rc;
                l++;
            }
        }
        while(l<=m){
            newid[nid++]=id[l];
            c[id[l]] += rc;
            l++;
        }
        while(r<=e)
            newid[nid++]=id[r++];
        for(int i=0; i<newid.length ;i++)
            id[i+s]=newid[i];
    }
}
