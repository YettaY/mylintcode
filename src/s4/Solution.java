package s4;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by Administrator on 2016/5/11.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        double[] ugly=new double[n];
        ugly[0]=1;
        int id=1,id2=0,id3=0,id5=0;
        while (id<n){
            double v= Math.min(ugly[id2]*2,Math.min(ugly[id3]*3,ugly[id5]*5));
            if (v==ugly[id2]*2)
                id2++;
            if (v==ugly[id3]*3)
                id3++;
            if (v==ugly[id5]*5)
                id5++;
            ugly[id++]=v;
        }
        return (int) ugly[n-1];
    }
}
