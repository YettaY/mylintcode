package leetcode.Easy;
import java.util.*;
/**
 * Created by yanglu on 16/8/6.
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class Moving_Average_from_Data_Stream {
    class MovingAverage {
        int size;
        List<Integer> l;
        double sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size=size;
            l=new ArrayList<Integer>();
        }

        public double next(int val) {
            l.add(val);
            sum+=val*1.0;
            if(l.size()>size)
                sum-=l.remove(0);

            return (double)sum/l.size();
        }
    }
}
