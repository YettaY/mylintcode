package Alibaba;

import java.util.*;

/**
 * Created by yanglu on 16/10/5.
 */
public class Main9 {
    static List<List<Integer>> adj;
    static int[] satis;
    static int N,M;
    public static int[] maxSatisRoom(Set<Integer> wireless){
        int room=0, maxsatis=0;
        for(int i=1;i<adj.size();i++){
            int cur = !wireless.contains(i) ? satis[i] : 0;
            for(int j=0;j<adj.get(i).size();j++){
                if(!wireless.contains(adj.get(i).get(j)))
                    cur+=satis[adj.get(i).get(j)];
            }
            if(cur>maxsatis){
                room=i;
                maxsatis=cur;
            }
        }
        return new int[]{room, maxsatis};
    }
    public static void dfs(List<Integer> router, List<Integer> ans, int id){
        if(router.size()==M-1){
            Set<Integer> wireless=new HashSet<>();
            for(int r:router){
                wireless.add(r);
                for(int i=0;i<adj.get(r).size();i++)
                    wireless.add(adj.get(r).get(i));
            }
            int[] rm=maxSatisRoom(wireless);
            int room=rm[0];
            wireless.add(room);
            for(int i=0;i<adj.get(room).size();i++)
                wireless.add(adj.get(room).get(i));
            int cur=0;
            for(int w:wireless)
                cur+=satis[w];
            ans.add(cur);
        }
        else{
            for(int i=id;i<adj.size();i++){
                router.add(i);
                dfs(router, ans, id+1);
                router.remove(router.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        N=in.nextInt();
        M=in.nextInt();
        satis=new int[N+1];//单个房间满意度
        adj=new ArrayList<List<Integer>>();
        adj.add(new ArrayList<>());
        for (int i=1;i<=N;i++) {
            satis[i] = in.nextInt();
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<=N-1;i++){
            int x=in.nextInt(), y=in.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        List<Integer> ans=new ArrayList<>();
        dfs(new ArrayList<Integer>(), ans, 1);
        System.out.println(Collections.max(ans));
    }
}
