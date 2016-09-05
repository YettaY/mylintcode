package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/4.
 * Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
 = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 Examples:
 input: 1
 output:
 []
 input: 37
 output:
 []
 input: 12
 output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 input: 32
 output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class Factor_Combinations {
    //Solution 1: 214ms
//    public List<List<Integer>> getFactors(int n) {
//        List<List<Integer>> r=new ArrayList<>();
//        dfs(r, new ArrayList<Integer>(), n, 2);
//        return r;
//    }
//    public void dfs(List<List<Integer>> r, List<Integer> cur, int n, int f){
//        if(n<=1){
//            if(cur.size()>1){
//                r.add(new ArrayList<>(cur));
//            }
//            return;
//        }
//        for(int i=f;i<=n;i++){
//            if(n%i==0){
//                cur.add(i);
//                dfs(r, cur, n/i, i);
//                cur.remove(cur.size()-1);
//            }
//        }
//    }

    //Solution 2:
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> r=new ArrayList<>();
        if(n<4)
            return r;
        dfs(r, new ArrayList<Integer>(), n, 2);
        return r;
    }
    public void dfs(List<List<Integer>> r, List<Integer> cur, int n, int f){
        int sqrt= (int) Math.sqrt(n);
        for(int i=f;i<=sqrt;i++){
            if(n%i==0){
                cur.add(i);
                dfs(r, cur, n/i, i);
                cur.add(n/i);
                r.add(new ArrayList<>(cur));
                cur.remove(cur.size()-1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
