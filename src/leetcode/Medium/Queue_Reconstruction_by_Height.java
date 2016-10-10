package leetcode.Medium;

import java.util.*;

/**
 * Created by Administrator on 2016/9/27.
pick up the tallest guy first
when insert the next tall guy, just need to insert him into kth position
repeat until all people are inserted into list
 */
public class Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o2[0]-o1[0] : o1[1]-o2[1];
            }
        });
        List<int[]> r=new ArrayList<>();
        for(int[] p:people){
            if(p[1]>=r.size())
                r.add(p);
            else
                r.add(p[1], p);
        }
        return r.toArray(new int[people.length][]);
    }
}
