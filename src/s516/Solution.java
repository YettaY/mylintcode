package s516;

/**
 * Created by Administrator on 2016/5/30.
 */
/**
 * 和I的思路一样，不过这里我们有K个颜色，不能简单的用Math.min方法了。
 * 如果遍历一遍颜色数组就找出除了自身外最小的颜色呢？我们只要把最小和次小的都记录下来就行了，
 * 这样如果和最小的是一个颜色，就加上次小的开销，反之，则加上最小的开销。*/
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0)
            return 0;
        int premin=0, presec=0, preid=-1;
        for (int i=0;i<costs.length;i++){
            int curmin=Integer.MAX_VALUE, cursec=Integer.MAX_VALUE, curid=-1;
            for (int j=0;j<costs[0].length;j++){
                costs[i][j]+=(preid==j)?presec:premin;
                if (costs[i][j]<curmin){
                    cursec=curmin;
                    curmin=costs[i][j];
                    curid=j;
                }
                else if(costs[i][j]<cursec)
                    cursec=costs[i][j];
            }
            preid=curid;
            premin=curmin;
            presec=cursec;
        }
        return premin;
    }
}
