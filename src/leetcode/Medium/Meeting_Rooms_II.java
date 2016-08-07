package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/6.
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
public class Meeting_Rooms_II {
    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();


        //Solution2:
//        if(intervals==null || intervals.length==0)
//            return 0;
//        int[] s=new int[intervals.length], e=new int[intervals.length];
//        for(int i=0;i<intervals.length;i++){
//            s[i]=intervals[i].start;
//            e[i]=intervals[i].end;
//        }
//        Arrays.sort(s);
//        Arrays.sort(e);
//        int curend=0,r=0;
//        for(int i=0;i<intervals.length;i++){
//            if(s[i]<e[curend])
//                r++;
//            else
//                curend++;
//        }
//        return r;

    }
    public static void main(String[] args){
        Interval[] in=new Interval[3];
        in[0]=new Interval(0,30);
        in[1]=new Interval(5,10);
        in[2]=new Interval(15,20);
        System.out.println(minMeetingRooms(in));
    }

}
