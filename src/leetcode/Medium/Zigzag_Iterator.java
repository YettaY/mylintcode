package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/5.
 * Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].
 */
public class Zigzag_Iterator {
//    class ZigzagIterator {
//        Queue<Integer> q=new LinkedList<Integer>();
//        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//            int n=Math.max(v1.size(),v2.size());
//            for(int i=0;i<n;i++){
//                if(i<v1.size())
//                    q.offer(v1.get(i));
//                if(i<v2.size())
//                    q.offer(v2.get(i));
//            }
//        }
//
//        public int next() {
//            return q.poll();
//        }
//
//        public boolean hasNext() {
//            return !q.isEmpty();
//        }
//    }

    //Solution2: o(1) space
    class ZigzagIterator {
        Iterator<Integer> i,j,t;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            j=v1.iterator();
            i=v2.iterator();
        }

        public int next() {
            if(j.hasNext()){
                t=j;
                j=i;
                i=t;
            }
            return i.next();
        }

        public boolean hasNext() {
            return j.hasNext() || i.hasNext();
        }
    }

}
