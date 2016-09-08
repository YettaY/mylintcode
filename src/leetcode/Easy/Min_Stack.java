package leetcode.Easy;
import java.util.*;
/**
 * Created by Administrator on 2016/9/6.
 */
public class Min_Stack {
    //Solution 1:
//    class MinStack {
//        Stack<Integer> s=new Stack<Integer>();
//        Stack<Integer> min=new Stack<Integer>();
//        /** initialize your data structure here. */
//        public MinStack() {
//            s=new Stack<Integer>();
//            min=new Stack<Integer>();
//        }
//
//        public void push(int x) {
//            if(min.isEmpty() || min.peek()>=x)
//                min.push(x);
//            s.push(x);
//        }
//
//        public void pop() {
//            if(min.peek().equals(s.peek()))
//                min.pop();
//            s.pop();
//        }
//
//        public int top() {
//            return s.peek();
//        }
//
//        public int getMin() {
//            return min.peek();
//        }
//    }

    //Solution 2:
    class MinStack {
        Stack<Integer> s=new Stack<Integer>();
        int min=Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
            s=new Stack<Integer>();
        }

        public void push(int x) {
            if(min>=x) {
                s.push(min);
                min = x;
            }
            s.push(x);
        }

        public void pop() {
            if(min==s.peek()) {
                s.pop();
                min=s.peek();
                s.pop();
            }
            else
                s.pop();
            if (s.isEmpty())
                min=Integer.MAX_VALUE;
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
