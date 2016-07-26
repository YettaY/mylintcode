package Microsoft.Tanxing_SummerCamp;

import java.util.*;

public class Main2 {
    static class tree{
        long x,y;
        public tree(long x, long y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s=in.nextLine().split(" ");
        int N=Integer.valueOf(s[0]), M=Integer.valueOf(s[1]);
        long tn= (long) Math.pow(2,N)-1;
        tree[] ts=new tree[(int) tn];
        ts[0]=new tree(0,0);
        for (int i=1;i<=tn/2;i++) {
            if (i==1) {
                ts[i] =  new tree(i * 2, i * 2);
                ts[i * 2] = new tree(i * 2, i * 2*(-1));
            }
            else {
                ts[i] =  new tree(6 * (i - 1), 6 * (i - 1));
                ts[i * 2] =new tree(6 * (i - 1), 6 * (i - 1)*(-1));
            }
        }
        for (int i=0;i<M;i++){
            int r=0;
            s=in.nextLine().split(" ");
            int x1=Integer.valueOf(s[0]), y1=Integer.valueOf(s[1]), x2=Integer.valueOf(s[2]),y2=Integer.valueOf(s[3]);
            for(int j=0;j<tn;j++){
                if (x1>=0 && y1<=0 && x2>=0 && y2<=0){
                    if (ts[j].x>=x1 && ts[j].y>=y1 && ts[j].x<=x2 && ts[j].y<=y2)
                        r++;
                }
                else if (x1>=0 && y1>=0 && x2>=0 && y2>=0){
                    if (ts[j].x>=x1 && ts[j].y>=y1 && ts[j].x<=x2 && ts[j].y<=y2)
                        r++;
                }
                else if (x1>=0 && y1<=0 && x2>=0 && y2>=0){
                    if (ts[j].x>=x1 && ts[j].y>=y1 && ts[j].x<=x2 && ts[j].y<=y2)
                        r++;
                }
                else if (x1<=0 && y1<=0 && x2>=0 && y2>=0){
                    if (ts[j].x>=x1 && ts[j].y>=y1 && ts[j].x<=x2 && ts[j].y<=y2)
                        r++;
                }
            }
            System.out.println(r);
        }
    }
}
