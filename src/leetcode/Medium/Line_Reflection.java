package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Find the smallest and largest x-value for all points.
 If there is a line then it should be at y = (minX + maxX) / 2.
 For each point, make sure that it has a reflected point in the opposite side.

 */
public class Line_Reflection {
    public boolean isReflected(int[][] points) {
        //Solution 1:
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        HashSet<String> set = new HashSet<>();
//        for (int[] p : points) {
//            max = Math.max(max, p[0]);
//            min = Math.min(min, p[0]);
//            String str = p[0] + "a" + p[1];
//            set.add(str);
//        }
//        int sum = max + min;
//        for (int[] p : points) {
//            //int[] arr = {sum-p[0],p[1]};
//            String str = (sum - p[0]) + "a" + p[1];
//            if (!set.contains(str))
//                return false;
//
//        }
//        return true;


        // Solution 2:
//        Map<Integer,Set<Integer>> map=new HashMap<>();
//        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
//        for(int[] p:points){
//            if(!map.containsKey(p[1]))
//                map.put(p[1],new HashSet<Integer>());
//            map.get(p[1]).add(p[0]);
//            max=Math.max(max,p[0]);
//            min=Math.min(min,p[0]);
//        }
//        int sum=max+min;
//        for(Set<Integer> set:map.values()){
//            for(Integer x:set) {
//                if (!set.contains(sum - x))
//                    return false;
//            }
//        }
//
//        return true;

        //Solution 3:
        /*Find the axis first,sort the points with same x according to their y.
        if x <= axis, y in ascending order; if x > axis, y in decreasing order).
        Then in while loop, you need to jump the identical points as well as points on the axis.*/
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int[] p:points){
            max=Math.max(max,p[0]);
            min=Math.min(min,p[0]);
        }//axis=(max+min)/2;
        int sum=max+min;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else if(o1[0]*2<=sum)
                    return o1[1] - o2[1];
                else
                    return o2[1] - o1[1];
            }
        });
        int l=0, r= points.length-1;
        while(l<=r){
            //points[l][0]-min!=max-points[r][0]
            if(points[l][0] + points[r][0]!= sum)
                return false;
            else if( points[l][0]*2!=sum && points[l][1]!=points[r][1]) //没在轴上，和另一个点的y值还不一样，不对称
                return false;
            while(l+1<points.length && points[l][0]==points[l+1][0])
                l++;
            while(r-1>=0 && points[r][0]==points[r-1][0])
                r--;
            l++;
            r--;
        }
        return true;
    }
}
