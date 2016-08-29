package g_apac.Round_B_APAC_Test_2017;

import java.io.*;
import java.util.*;
/**
 * Created by Administrator on 2016/8/28.
 */
public class Main3 {
    static class interval{
        private long s;
        private long e;
        public interval(long s,long e){
            this.s=s;
            this.e=e;
        }
    }
    public static void main(String[] args) throws IOException {
       // BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\C-small-attempt3.in"));
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\in.txt"));
        int t = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\out.txt"));

        for (int id = 1; id <= t; id++) {
            long ans=0;
            String line = br.readLine();
            String[] str = line.split(" ");
            long n=Long.valueOf(str[0]), l1=Long.valueOf(str[1]), r1=Long.valueOf(str[2]),
                    a=Long.valueOf(str[3]),b=Long.valueOf(str[4]), c1=Long.valueOf(str[5]),c2=Long.valueOf(str[6]),m=Long.valueOf(str[7]);
            List<interval> in=new ArrayList<>();
            in.add(new interval(l1,r1));
            long x1=l1,y1=r1;
            for(int i=1;i<n;i++){
                long x=(a*x1 + b*y1 + c1)%m;
                long y=(a*y1 + b*x1 + c2)%m;

                l1 = Math.min(x,y);
                r1 = Math.max(x,y);
                x1=x;y1=y;
                interval cur=new interval(l1,r1);
                in.add(cur);
            }
//            System.out.println("--------------"+id);
//            for(interval e:in){
//                System.out.println(e.s+" "+e.e);
//            }
 //           System.out.println();
            long min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){

//                for(interval e:in){
//                    System.out.println(e.s+" "+e.e);
//                }
                List<interval> tmp=new ArrayList<interval>(in);
                tmp.remove(i);

//                for(interval e:tmp){
//                    System.out.println(e.s+" "+e.e);
//                }

                min=Math.min(min, merge(tmp));
            }
            bw.write("Case #" + id + ": " + min + "\n");
        }
        br.close();
        bw.close();
    }
    public static long merge(List<interval> intervals) {
        long ans=0;
        List<interval> r=new ArrayList<>();
        if(intervals==null || intervals.size()<2) {
            if(intervals.size()==1){
                ans=intervals.get(0).e-intervals.get(0).s+1;
                return ans;
            }
            return 0;
        }
        Collections.sort(intervals,new Comparator<interval>(){
            public int compare(interval a, interval b){
                return (int)(a.s-b.s);
            }
        });

        interval pre=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            interval cur=intervals.get(i);
            if(cur.s<=pre.e) {
                pre = new interval(pre.s,Math.max(pre.e, cur.e));
            }
            else{
                r.add(pre);
                ans+=(pre.e-pre.s+1);
                pre=cur;
            }
        }
        ans+=(pre.e-pre.s+1);
        r.add(pre);
//      for(interval e:r){
//            System.out.println(e.s+" "+e.e);
//        }
//        System.out.println("ans: "+ans);
//        System.out.println();
        return ans;
    }
}
