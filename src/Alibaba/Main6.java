package Alibaba;

import java.util.*;
/**
 * Created by yanglu on 16/9/23.
 * WAP-wireless routers
 */

public class Main6 {
    static class rs{
        int id;
        int val;
        Set<Integer> door;
        public  rs (int id, int val){
            this.id=id;
            this.val=val;//获得每个房间和它相邻的房间总共的满意度
            this.door=new HashSet<Integer>();//存储与id连接的门
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(), m=in.nextInt();
        int[] satis=new int[n];//单个房间满意度
        LinkedList<rs> room=new LinkedList<rs>();
        int allsatis=0;
        for (int i=0;i<n;i++) {
            int v=in.nextInt();
            satis[i] = v;
            allsatis+=v;
            room.add(new rs(i, v));
        }
        for(int i=0;i<n-1;i++){
            int x=in.nextInt(), y=in.nextInt();
            room.get(x-1).val+=satis[y-1];  //与x相邻的y的满意度加到x上
            room.get(y-1).val+=satis[x-1];  //与y相邻的x的满意度加到y上
            room.get(x-1).door.add(y-1);
            room.get(y-1).door.add(x-1);
        }

        Set<Integer> set=new HashSet<>();
        LinkedList<rs> tmp=new LinkedList<rs>(room);
        int needm=0;
        while(set.size()<n){
            Collections.sort(tmp, new Comparator<rs>() {

                @Override
                public int compare(rs o1, rs o2) {
                    return o2.door.size() - o1.door.size();
                }
            });//按度最大排序
            set.add(tmp.get(0).id);
            for(int id: tmp.get(0).door){
                set.add(id);
            }
            tmp.remove(0);
            needm++;
        }
        if(needm<=m){//最多需要的路由器数和m一样
            System.out.println(allsatis);
            return;
        }
        int ans=0;
        for(int i=0;i<m;i++){
            if(room.size()>0) {
                Collections.sort(room, new Comparator<rs>() {

                    @Override
                    public int compare(rs o1, rs o2) {
                        return o2.val - o1.val;
                    }
                });//按满意度最大排序
                ans += room.get(0).val;
                int id = room.get(0).id;
                Set<Integer> adj=room.get(0).door;
                for (int j = 1; j < room.size(); j++) {
                    if (room.get(j).door != null ) {
                        if(room.get(j).door.contains(id)) {
                            room.get(j).val -= satis[id];
                            room.get(j).door.remove(id);
                        }//若包含最大满意度点，则删除最大满意度点
                        for(int a:adj){
                            if(room.get(j).door != null  && room.get(j).door.contains(a))
                                room.get(j).val -= satis[a];//减去最大满意度点的邻接点的satisfaction值
                            if(room.get(j).id==a)
                                room.get(j).val -= satis[a];//若当前点就是最大满意度点的邻接点，还要减去自身的值
                        }
                        if (room.get(j).door.size() == 0)
                            room.remove(j);//没有临界点则删除
                    }
                }
                room.removeFirst();
            }
            else
                break;
        }
        System.out.println(ans);
    }
}

