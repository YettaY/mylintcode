package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix {
    public static class Point {
        int val;
        int x;
        int y;
        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    public static int kthSmallest(int[][] matrix, int k) {
        //Solution 1:
//        if(matrix.length == 0) return 0;
//        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>(){
//            @Override
//            public int compare(Point a, Point b) {
//                return a.val - b.val;
//            }
//        });
//        pq.offer(new Point(matrix[0][0], 0, 0));
//        for(int i = 1; i < k; i++) {
//            Point p = pq.poll();
//            if((p.x+1) < matrix.length) {
//                pq.offer(new Point(matrix[p.x+1][p.y], p.x+1, p.y));
//            }
//            if(p.x == 0 && (p.y+1) < matrix.length) {
//                pq.offer(new Point(matrix[p.x][p.y+1], p.x, p.y+1));
//            }
//        }
//        return pq.poll().val;

        //Solution2:
        int l=matrix[0][0], h=matrix[matrix.length-1][matrix[0].length-1];
        while(l<h){
            int mid=(l+h)/2, c=0, j=matrix[0].length;
            for(int i=0;i<matrix.length;i++){
                while(j>=1 && matrix[i][j-1]>mid)
                    j--;
                c+=j;
            }
            if(c<k)
                l=mid+1;
            else
                h=mid;
        }
        return l;
    }
    public static void main(String[] args){
        int[][] m={{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(m,8));
    }

}
