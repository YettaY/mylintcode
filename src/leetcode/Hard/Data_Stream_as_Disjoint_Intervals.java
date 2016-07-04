package leetcode.Hard;
import java.util.*;
/**
 * Created by Administrator on 2016/7/4.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Data_Stream_as_Disjoint_Intervals {
    TreeMap<Integer, Interval> map=new TreeMap<>();

    public class SummaryRanges {
        /** Initialize your data structure here. */
        public SummaryRanges() {
            map=new TreeMap<Integer, Interval>();
        }

        public void addNum(int val) {
            if (map.containsKey(val))
                return;
            Integer l=map.lowerKey(val), h=map.higherKey(val);
            if (l!=null && h!=null && map.get(l).end+1==val && h==val+1){
                map.get(l).end=map.get(h).end;
                map.remove(h);
            }
            else if (l!=null && map.get(l).end+1>=val){
                map.get(l).end=Math.max(map.get(l).end, val);
            }
            else if (h!=null && h==val+1){
                map.put(val,new Interval(val, map.get(h).end));
                map.remove(h);
            }
            else{
                map.put(val, new Interval(val, val));
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(map.values());
        }
    }
}
