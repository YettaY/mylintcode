package leetcode.Hard;
import java.util.*;
/**
 * Created by Administrator on 2016/8/30.
 *
 1. 先考虑所有点的row值，如上图为0， 0， 2，则中值为0， 所有点距中值的距离和为(0 - 0) + (0 - 0) + (2 - 0) = 2
 同理，考虑所有点的cols值，上图为，0, 2, 4，中值为2，所有点距中值的距离和为(2- 0) + (2 - 2) + (4 - 2) = 4，
 所以总距离为2 + 4 = 6。 O(N^3lgn)
 2.Before solving the 2D problem we first consider a 1D case. The solution is quite simple. Just find the median of all the x coordinates and calculate the distance to the median.
 Alternatively, we can also use two pointers to solve the 1D problem. left and right are how many people one left/right side of coordinates i/j. If we have more people on the left we let j decrease otherwise increase i. The time complexity is O(n) and space is O(1).
 To be more clear, a better view is we can think i and j as two meet points. All the people in [0, i] go to meet at i and all the people in [j, n - 1] meet at j. We let left = sum(vec[:i+1]), right = sum(vec[j:]), which are the number of people at each meet point, and d is the total distance for the left people meet at i and right people meet at j.
 Our job is to let i == j with minimum d.
 If we increase i by 1, the distance will increase by left since there are 'left' people at i and they just move 1 step. The same applies to j, when decrease j by 1, the distance will increase by right. To make sure the total distance d is minimized we certainly want to move the point with less people. And to make sure we do not skip any possible meet point options we need to move one by one.
 For the 2D cases we first need to sum the columns and rows into two vectors and call the 1D algorithm.
 The answer is the sum of the two. The time is then O(mn) and extra space is O(m+n)
 Moreover, the solution is still O(mn) with the follow up:
 What if there are people sharing same home?
 In other words the number in the grid can be more than 1.
 */
public class Best_Meeting_Point {
    // Solution 1:
//    public int minTotalDistance(int[][] grid) {
//        List<Integer> x=new ArrayList<>(), y=new ArrayList<>();
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]==1){
//                    x.add(i);
//                    y.add(j);
//                }
//            }
//        }
//        return getdis(x)+getdis(y);
//    }
//    public int getdis(List<Integer> n){
//        Collections.sort(n);
//        int i=0, j=n.size()-1;
//        int d=0;
//        while(i<j)
//            d += n.get(j--) - n.get(i++);
//
//        return d;
//    }

    //Solution 2:
    public int minTotalDistance(int[][] grid) {
        int[] rsum=new int[grid[0].length], csum=new int[grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) {
                rsum[j] += grid[i][j];
                csum[i] += grid[i][j];
            }
        }
        return getdis(rsum)+getdis(csum);
    }

    private int getdis(int[] n) {
        int i=-1, j=n.length, left=0, right=0, d=0;
        while(i!=j){
            if(left<right){
                d+=left;
                left+=n[++i];
            }
            else{
                d+=right;
                right+=n[--j];
            }
        }
        return d;
    }

}
