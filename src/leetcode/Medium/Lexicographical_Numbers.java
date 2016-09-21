package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/19.
 * The basic idea is to find the next number to add.
 Take 45 for example: if the current number is 45, the next one will be 450 (450 == 45 * 10)(if 450 <= n), or 46 (46 == 45 + 1) (if 46 <= n) or 5 (5 == 45 / 10 + 1)(5 is less than 45 so it is for sure less than n).
 We should also consider n = 600, and the current number = 499, the next number is 5 because there are all "9"s after "4" in "499" so we should divide 499 by 10 until the last digit is not "9".
 It is like a tree, and we are easy to get a sibling, a left most child and the parent of any node.
 */
public class Lexicographical_Numbers {
    //Solution 1：
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> r=new ArrayList<Integer>();
//        r.add(1);
//        for(int i=1, pre=1;i<n;i++){
//            if(pre*10 < n)
//                pre *= 10;
//            else{
//                while(pre%10 ==9 || pre==n)
//                    pre /=10;
//                pre++;
//            }
//            r.add(pre);
//        }
//        return r;
//    }

    //Solution 2:
    /*The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
Then we visit every node in pre-order.
       1        2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ....*/
    public List<Integer> lexicalOrder(int n) {
        List<Integer> r=new ArrayList<Integer>();
        for(int i=1;i<10;i++)
            dfs(r, n, i);

        return r;
    }
    public void dfs(List<Integer> r, int n, int cur){
        if(cur > n)
            return;
        r.add(cur);
        for(int i=0;i<10;i++){
            if(10*cur+i>n)
                return;
            dfs(r, n,10*cur+i);
        }
    }
}
