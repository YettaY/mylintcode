package leetcode.Easy;

import google.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2016/9/4.
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
public class Meeting_Rooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        //Solution 1:
//        int[] s=new int[intervals.length], e=new int[intervals.length];
//        for(int i=0;i<intervals.length;i++){
//            s[i]=intervals[i].start;
//            e[i]=intervals[i].end;
//        }
//        Arrays.sort(s);
//        Arrays.sort(e);
//        int curend=0, r=0;
//        for(int i=0;i<intervals.length;i++){
//            if(s[i]<e[curend]) {
//                r++;
//                if(r>1)
//                    return false;
//            }
//            else
//                curend++;
//        }
//        return true;

        //Solution 2:
        if(intervals==null)
            return false;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        for(int i=1;i<intervals.length;i++)
            if(intervals[i].start<intervals[i-1].end)
                return false;
        return true;
    }
}
