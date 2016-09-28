package leetcode.Hard;
import java.util.*;
/**
 * Created by Administrator on 2016/9/27.
 * 1.可以用递归来做，我们维护一个变量res，表示青蛙能跳到的最远的石头，这样最后我们看res是否到达最后一块石头就知道青蛙是否能过河了。
 * 然后我们需要两个变量start和jump分别用来表示当前的石头位置和此时青蛙的弹跳力，我们遍历余下的所有石头，
 * 对于遍历到的石头，我们计算到当前石头的距离dist，如果遍历到第二个石头，而距离不是1的话，则返回false，因为题目中规定了青蛙第一次跳跃距离必须是1。
 * 对于其他石头，我们检测距离和弹跳力的关系，如果满足题意，说明可以跳到该石头上，我们更新res，然后对该石头继续调用递归函数
 *2.Use map to represent a mapping from the stone (not index) to the steps that can be taken from this stone.

 so this will be

 [0,1,3,5,6,8,12,17]

 {17=[], 0=[1], 1=[1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5]}

 Notice that no need to calculate the last stone.

 On each step, we look if any other stone can be reached from it, if so, we update that stone's steps by adding step, step + 1, step - 1. If we can reach the final stone, we return true. No need to calculate to the last stone.
 */
public class Frog_Jump {
    //Solution 1: TLE
//    public static boolean canCross(int[] stones) {
//        if(stones[1]>1)
//            return false;
//        if(stones.length==2)
//            return true;
//        return helper(stones, 1, 1);
//    }
//
//    private static boolean helper(int[] stones, int start, int jump) {
//        if(start>= stones.length-1)
//            return true;
//        for(int i=start+1;i<stones.length;i++){
//            if(stones[start]+jump+1>=stones[i] && stones[start]+jump-1<=stones[i])
//                if(helper(stones, i, stones[i]-stones[start]))
//                    return true;
//        }
//        return false;
//    }

    //Solution 2:
    public static boolean canCross(int[] stones) {
        if(stones.length==0)
            return true;
        Map<Integer, Set<Integer>> map=new HashMap<>();
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for(int i=1;i<stones.length;i++)
            map.put(stones[i], new HashSet<Integer>());
        for(int i=0;i<stones.length-1;i++){
            int cur=stones[i];
            for(int jump:map.get(cur)){
                int reach=cur+jump;
                if(reach==stones[stones.length-1])
                    return true;
                Set<Integer> set=map.get(reach);
                if(set!=null){
                    set.add(jump);
                    if(jump-1>0)
                        set.add(jump-1);
                    set.add(jump+1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] s={0,1,3,5,6,8,12,17};
        System.out.println(canCross(s));
    }
}
