package Alibaba;

import java.util.*;

public class Main3
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        if(n==1){
            System.out.print(1);
            return;
        }
        List<List<Integer>> es=new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++)
            es.add(new ArrayList<Integer>());
        int[][] m=new int[n-1][2];
        for(int i=0;i<n-1;i++){
            m[i][0]=in.nextInt();
            m[i][1]=in.nextInt();
        }
        int[] pre=new int[n];
        for(int[] e:m){
            es.get(e[0]).add(e[1]);
            pre[e[1]]++;
        }
        //System.out.println(es);
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<pre.length;i++){
            if(pre[i]==0)
                q.offer(i);
        }
        int ans=1;
        Deque<Integer> cnt=new LinkedList<>();
        cnt.offer(0);
        int childs=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            if(!cnt.isEmpty())
                childs=cnt.pollFirst();
            if(childs==1){
                ans++;
            }
            else {
                cnt.addFirst(--childs);
            }
            int id=0;
            for(int i:es.get(cur)) {
                if ((--pre[i]) == 0) {
                    id++;
                    q.offer(i);
                }
            }
            if(id!=0)
                cnt.addLast(id);
        }
        System.out.print(ans);
    }

}