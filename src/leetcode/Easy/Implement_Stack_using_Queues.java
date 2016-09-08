package leetcode.Easy;
import java.util.*;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Implement_Stack_using_Queues {
    //Solution 1:
//    class MyStack {
//        Queue<Integer> q1=new LinkedList<Integer>();
//        Queue<Integer> q2=new LinkedList<Integer>();
//        // Push element x onto stack.
//        public void push(int x) {
//            q1.offer(x);
//        }
//
//        // Removes the element on top of the stack.
//        public void pop() {
//            while(q1.size()>1)
//                q2.offer(q1.poll());
//            q1.poll();
//            Queue<Integer> t=q1;
//            q1=q2;
//            q2=t;
//        }
//
//        // Get the top element.
//        public int top() {
//            while(q1.size()>1)
//                q2.offer(q1.poll());
//            return q1.peek();
//        }
//
//        // Return whether the stack is empty.
//        public boolean empty() {
//            return q1.isEmpty() && q2.isEmpty();
//        }
//    }

    //Solution 2:
    class MyStack {
        Queue<Integer> q=new LinkedList<Integer>();
        // Push element x onto stack.
        public void push(int x) {
            q.offer(x);
            for(int i=0;i<q.size()-1;i++)
                q.offer(q.poll());
        }

        // Removes the element on top of the stack.
        public void pop() {
            q.poll();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
