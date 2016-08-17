package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 * Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Flatten_2D_Vector {
    //Solution 1:
//    class Vector2D implements Iterator<Integer> {
//        Stack<List<Integer>> s;
//        Stack<Integer> get;
//        public Vector2D(List<List<Integer>> vec2d) {
//            s=new Stack<List<Integer>>();
//            get=new Stack<Integer>();
//            for(int i=0;i<vec2d.size();i++)
//                s.push(vec2d.get(i));
//        }
//
//        @Override
//        public Integer next() {
//            return get.pop();
//        }
//
//        @Override
//        public boolean hasNext() {
//            while(!s.isEmpty()){
//                List<Integer> cur=s.pop();
//                for(int i=cur.size()-1;i>=0;i--)
//                    get.push(cur.get(i));
//            }
//            return !get.isEmpty();
//        }
//    }


    //Solution 2:
    class Vector2D {

        private Iterator<List<Integer>> i;
        private Iterator<Integer> j;

        public Vector2D(List<List<Integer>> vec2d) {
            i = vec2d.iterator();
        }

        public int next() {
            hasNext();
            return j.next();
        }

        public boolean hasNext() {
            while ((j == null || !j.hasNext()) && i.hasNext())
                j = i.next().iterator();
            return j != null && j.hasNext();
        }
    }
}
