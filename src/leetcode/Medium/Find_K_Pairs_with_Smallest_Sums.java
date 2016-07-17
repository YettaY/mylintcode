package leetcode.Medium;
import  java.util.*;

/**
 * Created by Administrator on 2016/7/17.
 */
public class Find_K_Pairs_with_Smallest_Sums {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList r=new ArrayList<int[]>();
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return r;
     //   Set<int[]> set=new HashSet<>();
        Queue<int[]> q=new PriorityQueue<int[]>(11, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1=o1[0]+o1[1], sum2=o2[0]+o2[1];
                return sum1-sum2;
            }
        });
        TreeSet<int[]> set= new TreeSet<int[]>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int[] n1= (int[]) o1, n2=(int[]) o2;
                int sum1=n1[0]+n1[1], sum2=n2[0]+n2[1];
                return sum1-sum2;
            }
        });
        boolean f=false;
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                int[] arr={nums1[i], nums2[j]};
                q.add(arr);
//                if (q.size()==k) {
//                    f=true;
//                    break;
//                }
//                if (!set.contains(arr)) {
//                    set.add(arr);
//                    if (set.size()==k) {
//                        f=true;
//                        break;
//                    }
//                }
            }
//            if (f)
//                break;
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
