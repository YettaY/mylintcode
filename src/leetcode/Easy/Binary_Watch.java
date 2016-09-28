package leetcode.Easy;
import java.util.*;
/**
 * Created by Administrator on 2016/9/27.
 * 1.Solution1:
 *  To differentiate hours and minutes by bit, as hours will occupy 4 bits, and minutes will occupy 6.
 Integer.bitCount(m + (h << 6))
 You could also do:
 Integer.bitCount(m) + Integer.bitCount(h)

 2.Solution 2:
 上面的方法之所以那么简洁是因为用了bitset这个类，如果我们不用这个类，那么应该怎么做呢？
 这个灯亮问题的本质其实就是在n个数字中取出k个，那么就跟之前的那道Combinations一样，我们可以借鉴那道题的解法，
 那么思路是，如果总共要取num个，我们在小时集合里取i个，算出和，然后在分钟集合里去num-i个求和，如果两个都符合题意，那么加入结果中即可
 */
public class Binary_Watch {
    public static List<String> readBinaryWatch(int num) {
        //Solution 1:
//        List<String> r=new ArrayList<>();
//        for(int h=0;h<12;h++){
//            for(int m=0;m<60;m++){
//                if(Integer.bitCount((h<<6)+m)==num) // 二进制整数中1的个数
//                    r.add(String.format("%d:%02d", h, m));  //数字前面补0
//            }
//        }
//        return r;

        //Solution 2:
        List<String> r=new ArrayList<>();
        int[] hour={8,4,2,1}, min={32,16,8,4,2,1};
        for(int i=0;i<=num;i++){
            List<Integer> hs=gen(hour, i), ms=gen(min, num-i);
            for(int h:hs){
                if(h>11) continue;
                for(int m:ms){
                    if(m>59) continue;
                    r.add(new String(h+(m<10 ? ":0" : ":")+m));
                }
            }
        }
        return r;
    }

    private static List<Integer> gen(int[] n, int cnt) {
        List<Integer> r=new ArrayList<>();
        dfs(n, r, cnt, 0, 0);
        return r;
    }

    private static void dfs(int[] n, List<Integer> r, int cnt, int id, int cur) {
        if(cnt==0){
            r.add(cur);
            return;
        }
        for(int i=id;i<n.length;i++){
            dfs(n, r, cnt-1, i+1, n[i]+cur);
        }
    }
    public static void main(String[] args){
        System.out.println(readBinaryWatch(1));
    }
}
