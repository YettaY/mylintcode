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
class point{
    int time;
    int flag;
    public point(int t,int s){
        this.time=t;
        this.flag=s;
    }
}
public class s391 {
    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes==null || airplanes.size()==0)
            return 0;
        List<point> list=new ArrayList<>();
        for (Interval t:airplanes){
            list.add(new point(t.start,1));
            list.add(new point(t.end,0));
        }
        Collections.sort(list, new Comparator<point>() {
            public int compare(point o1, point o2) {
                if (o1.time!=o2.time)
                    return o1.time-o2.time;//返回-1 表示o1小于o2 升序
                return o1.flag-o2.flag;  //降落0 有优先权
            }
        });
//        for(point t:list){
//            System.out.println(t.time+" "+t.flag);
//        }
        int max=0,cur=0;
        for(point p:list){
            if (p.flag==1)
                cur++;
            else
                cur--;
            max=Math.max(max,cur);
        }
        return max;
    }
    public static void main(String[] args){
        List<Interval> airplanes=new ArrayList<>();

//        Interval t1=new Interval(1,10);
//        Interval t2=new Interval(2,3);
//        Interval t3=new Interval(5,8);
//        Interval t4=new Interval(4,7);
//        airplanes.add(t1);
//        airplanes.add(t2);
//        airplanes.add(t3);
//        airplanes.add(t4);

        Interval t5=new Interval(1,4);
        Interval t6=new Interval(4,5);
        Interval t7=new Interval(2,4);
        airplanes.add(t5);
        airplanes.add(t6);
        airplanes.add(t7);
        System.out.println(countOfAirplanes(airplanes));
    }
}
