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
    //Solution 1;
//    public class SummaryRanges {
//        TreeMap<Integer, Interval> map=new TreeMap<>();
//        /** Initialize your data structure here. */
//        public SummaryRanges() {
//            map=new TreeMap<Integer, Interval>();
//        }
//
//        public void addNum(int val) {
//            if (map.containsKey(val))
//                return;
//            Integer l=map.lowerKey(val), h=map.higherKey(val);
//            if (l!=null && h!=null && map.get(l).end+1==val && h==val+1){
//                map.get(l).end=map.get(h).end;
//                map.remove(h);
//            }
//            else if (l!=null && map.get(l).end+1>=val){
//                map.get(l).end=Math.max(map.get(l).end, val);
//            }
//            else if (h!=null && h==val+1){
//                map.put(val,new Interval(val, map.get(h).end));
//                map.remove(h);
//            }
//            else{
//                map.put(val, new Interval(val, val));
//            }
//        }
//
//        public List<Interval> getIntervals() {
//            return new ArrayList<>(map.values());
//        }
//    }

    //Solution 2：
    /*Use the binary search to find an index in the existing list of intervals or find whether the number is already in the list.
    The returning index point to an interval which's start > val.
    Update this interval start to val if its start == val+1.
    Check the end value of the interval prior to this one if the returning index does not point to the first one.
    Merge these two intervals when they are connected by val. Or update the end value of the prior if its end value == val-1.
    Otherwise, add a new Interval for val.*/
    public class SummaryRanges {
        List<Interval> r;
        /** Initialize your data structure here. */
        public SummaryRanges() {
            r=new ArrayList<Interval>();
        }

        public void addNum(int val) {
            if(r.isEmpty()){
                r.add(new Interval(val, val));
                return;
            }
            else {
                Interval last=r.get(r.size()-1);
                if (val>last.end){
                    if(val==last.end+1)
                        last.end=val;
                    else
                        r.add(new Interval(val,val));
                    return;
                }
                int s=0, e=r.size();
                while (s<e){
                    int m=(s+e)/2;
                    Interval mid=r.get(m);
                    if(mid.start<=val && val<=mid.end)
                        return;
                    if(val<mid.start)
                        e=m;
                    else
                        s=m+1;
                }
                Interval cur=r.get(s);
                Interval pre=s>0?r.get(s-1):null;
                if((cur.start-1)==val){
                    cur.start=val;
                    if(pre!=null && pre.end+1==val) {
                        pre.end = cur.end;
                        r.remove(s);
                    }
                }
                else{
                    if(pre!=null && pre.end+1==val)
                        pre.end = val;
                    else
                        r.add(s, new Interval(val,val));
                }
            }
        }

        public List<Interval> getIntervals() {
            return r;
        }
    }
}
