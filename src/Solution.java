package s131;
import java.util.*;
/**
 * Created by Administrator on 2016/5/11.
 */
public class Solution {
    public static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> r=new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        if(buildings==null || buildings.length==0)
            return r;
        ArrayList<ArrayList<Integer>> h=new ArrayList<ArrayList<Integer>>();
        for(int[] i:buildings){
            ArrayList<Integer> left=new ArrayList<Integer>(), right=new ArrayList<Integer>();
            left.add(i[0]);
            left.add(-i[2]);
            right.add(i[1]);
            right.add(i[2]);
            h.add(left);
            h.add(right);
        }

        Collections.sort(h, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.get(0)!=o2.get(0))
                    return o1.get(0)-o2.get(0);
                return o1.get(1)-o2.get(1);
            }
        });
        Queue<Integer> q=new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        q.offer(0);
        int pre=0;
        ArrayList<Integer> t=new ArrayList<>();

        for(ArrayList<Integer> i:h){
            if(i.get(1)<=0)
                q.offer(-i.get(1));
            else
                q.remove(i.get(1));
            int cur=q.peek();
            if (pre!=cur){
                t.add(i.get(0));
                t.add(cur);
                r.add(t);
                t=new ArrayList<>();
                pre=cur;
            }
        }
        t=new ArrayList<>();
        if(r!=null && r.size()!=0){
            t.add(r.get(0).get(0));
            t.add(r.get(0).get(1));
            for(int i=1;i<r.size();i++){
                if (t.size()==2) {
                    t.add(1, r.get(i).get(0));
                    ans.add(t);
                    t = new ArrayList<>();
                    if (!r.get(i).get(1).equals(0)) {

                        if (i + 1 < r.size() && r.get(i + 1).get(0).equals(r.get(i).get(0))&&r.get(i + 1).get(1).equals(0)) {
                            i+=1;
                        } else {
                            t.add(r.get(i).get(0));
                            t.add(r.get(i).get(1));
                        }
                    }
                }
                else{
                    t.add(r.get(i).get(0));
                    t.add(r.get(i).get(1));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] buildings={{1,4,3},{1,1,5},{1,4,4}};
        int[][] b1={{1,3,3},{2,3,2},{3,4,1}};
        int[][] b2={{1,3,3},{2,4,4},{5,6,1}};
        int[][] b3={{127,131,585},{128,130,808},{129,130,284},{130,131,195},{131,135,47},{132,136,873}};
        //[127,128,585],[128,130,808],[130,131,585],[131,132,47],[132,136,873]
        int[][] b4={{1,1,5},{1,2,3},{2,2,5},{2,3,3},{3,3,5},{3,4,4}};
        System.out.println(buildingOutline(b2));

    }
}
