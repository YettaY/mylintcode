package s515;

/**
 * Created by Administrator on 2016/5/30.
 */
import java.util.*;

public class Solution {
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0)
            return 0;
        //Solution1:
//        for(int i=1;i<costs.length;i++){
//            for (int j=0;j<3;j++){
//                costs[i][j]+=Math.min(costs[i-1][(j+1)%3], costs[i-1][(j+2)%3]);
//            }
//        }

        //Solution2:
        for(int i=1;i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0], costs[i-1][1]);
        }

        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
}
