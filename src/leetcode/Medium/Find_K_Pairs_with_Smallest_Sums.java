package leetcode.Medium;
import  java.util.*;

/**
 * Created by Administrator on 2016/7/17.
 */
public class Find_K_Pairs_with_Smallest_Sums {
    static class Pair implements Comparable<Pair>{
        int[] pair;
        int id;
        int sum;
        public Pair(int id, int n1, int n2){
            this.id=id;
            pair=new int[]{n1,n2};
            this.sum=n1+n2;
        }
        public int compareTo(Pair p){
            return this.sum-p.sum;
        }
    }
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List r=new ArrayList<int[]>();
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return r;
        //Solution 1: O(KN)
//        int[] id=new int[nums1.length];
//        while(k-->0){
//            int min=Integer.MAX_VALUE;
//            int in=-1;
//            for(int i=0;i<nums1.length;i++){
//                if(id[i]>=nums2.length)
//                    continue;
//                if(nums1[i]+nums2[id[i]]<min){
//                    min=nums1[i]+nums2[id[i]];
//                    in=i;
//                }
//            }
//            if(in==-1)
//                break;
//            r.add(new int[]{nums1[in],nums2[id[in]]});
//            id[in]++;
//        }
//        return r;

        //Solution 2: O(klgk)
        Queue<Pair> q=new PriorityQueue<>();
        for(int i=0;i<nums1.length && i<k;i++){
            q.offer(new Pair(0,nums1[i],nums2[0]));
        }
        for(int i=1;i<=k && !q.isEmpty();i++){
            Pair cur=q.poll();
            r.add(cur.pair);
            if(cur.id+1< nums2.length)
                q.offer(new Pair(cur.id+1, cur.pair[0],nums2[cur.id+1]));
        }
        return r;
    }
    public static void main(String[] args){
        int[] n1={1,1,2}, n2={1,2,3};
        List<int[]> r=kSmallestPairs(n1,n2,2);
        for(int[] n:r)
            System.out.println(n[0]+" "+n[1]);
    }
}
