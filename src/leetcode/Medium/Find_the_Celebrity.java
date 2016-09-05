package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/2.
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

 Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

 You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

 Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class Find_the_Celebrity {
    public int findCelebrity(int n) {
        //Solution 1:
//        int c=0, r=0;
//        int[] a=new int[n];// a[i]是被认识的个数
//        int[] b=new int[n];//b[i]是i认识的人数
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i!=j && knows(i, j)) {
//                    a[j]++;//认识j的人数
//                    b[i]++;//i认识的人数
//                }
//            }
//        }
//        for (int i=0;i<a.length;i++){
//            if(a[i]==n-1 && b[i]==0){
//                c++;
//                if(c>1)
//                    return -1;
//                r=i;
//            }
//        }
//        return c==0 ? -1:r ;

        //Solution 2:
        /*The first pass is to pick out the candidate.
        If candidate knows i, then switch candidate.
        The second pass is to check whether the candidate is real.*/
        int r=0;
        for(int i=1;i<n;i++){
            if(knows(r,i))
                r=i;
        }
        for(int i=0;i<n;i++){
            if(i!=r && (knows(r, i) || !knows(i, r)))
                return -1;
        }
        return r;
    }
    public boolean knows(int a, int b){
        return true;
    }
}
