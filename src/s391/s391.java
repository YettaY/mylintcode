package s391; /**
 * Created by Administrator on 2016/6/5.
 */
import java.util.*;
class Interval{
    int start,end;
    Interval(int start,int end){
    this.start=start;
    this.end=end;
    }
}
public class s391 {
    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes==null || airplanes.size()==0)
            return 0;
        Collections.sort(airplanes, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start!=o2.start)
                    return o2.start-o1.start;
                return o2.end-o1.end;
            }
        });
        for(Interval t:airplanes){
            System.out.println(t.start+" "+t.end);
        }
        int max=0,cur=0,s=Integer.MAX_VALUE,e=Integer.MIN_VALUE;
        for (Interval t:airplanes){
            if (t.start<s)
                s=t.start;
            if (t.end>e)
                e=t.end;
        }
        for(int i=s,j=0;i<=e;i++){
            for (int k=j;k<airplanes.size();k++,j++ ){
                if (i==airplanes.get(k).start) {
                    cur++;
                    break;
                }
                else if (i==airplanes.get(k).end){
                    cur--;
                    break;
                }
            }
            max = Math.max(cur, max);
        }
        return max;
    }
    public static void main(String[] args){
        List<Interval> airplanes=new ArrayList<>();
        Interval t1=new Interval(1,10);
        Interval t2=new Interval(2,3);
        Interval t3=new Interval(5,8);
        Interval t4=new Interval(4,7);
        System.out.println(countOfAirplanes(airplanes));
    }
}
