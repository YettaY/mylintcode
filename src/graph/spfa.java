package graph;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * SPFA可以处理负权边  g_apac.Round_A_APAC_Test_2016的gCampus题
 * http://blog.csdn.net/kg20006/article/details/46327177

 */
public class spfa {
    static private class node{
        int s,e,c;
        public node(int s,int e,int c){
            this.s=s;
            this.e=e;
            this.c=c;
        }
    }

    static int n, m;
    static int[] u=new int[n], v=new int[n], w=new int[n];
    static int[] fir=new int[n], nex=new int[n];
    static int cnt;
    static int[][] path=new int[n][n], path1=new int[n][n];
    static int[][] dis=new int[n][n], dis1=new int[n][n];

    public static void add(int a, int b, int c){
        u[cnt] = a;
        v[cnt] = b;
        w[cnt] = c;
        nex[cnt] = fir[u[cnt]];
        fir[u[cnt]] = cnt ++;
    }

    public static void spfamax(int s){ //最长路
        boolean[] vis=new boolean[n];
        for(int i = 0; i < n; ++i)
            dis[s][i] = 0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        dis[s][s] = 0;
        while( !q.isEmpty() ){
            int a = q.poll();
            vis[a] = false;
            int k = fir[a];
            while(k != -1){
                int b = v[k], c = w[k];
                if(dis[s][b] < dis[s][a] + c){
                    dis[s][b] = dis[s][a] + c;
                    path[s][b] = a;
                    if(!vis[b]){
                        vis[b] = true;
                        q.offer(b);
                    }
                }
                k = nex[k];
            }
        }
    }
   public static void spfamin(int s){ //最短路
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i = 0; i < n; ++i)
            dis1[s][i] = Integer.MAX_VALUE;
        q.offer(s);
        vis[s] = true;
        dis1[s][s] = 0;
        while( !q.isEmpty() ){
            int a = q.poll();
            vis[a] = false;
            int k = fir[a];
            while(k != -1){
                int b = v[k], c = w[k];
                if(dis1[s][b] > dis1[s][a] + c){
                    dis1[s][b] = dis1[s][a] + c;
                    path1[s][b] = a;
                    if(!vis[b]){
                        vis[b] = true;
                        q.offer(b);
                    }
                }
                k = nex[k];
            }
        }
    }

   public static void print(int path[], int e,int flag){
        if(flag==1) { if(path[e] == -1) return; } //避免s结点输出两次
        else { if(e == -1) return;}
        print(path, path[e],flag);
       System.out.print(e+" ");
    }

    public static void main(String[] args)throws IOException {
        Scanner in=new Scanner(new File("C-large-practice.in"));//C-small-practice.in
        FileWriter fw=new FileWriter("out1.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int t=Integer.valueOf(in.nextInt());
        in.nextLine();//截取回车\r

        for (int id=1;id<=t;id++) {

            bw.write("Case #" + id + ":\n");
            String[] s = in.nextLine().split(" ");

            n = Integer.valueOf(s[0]);
            m = Integer.valueOf(s[1]);

            u=new int[40001]; v=new int[40001]; w=new int[40001];
            fir=new int[40001]; nex=new int[40001];
            path=new int[n][n]; path1=new int[n][n];
            dis=new int[n][n]; dis1=new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    path[i][j] = -1;
                    path1[i][j] = -1;

                }
                fir[i] = -1;
            }

            List<node> road=new ArrayList<>();

            cnt=0;
            for (int j=0;j<m;j++){
                s=in.nextLine().split(" ");
                int u=Integer.valueOf(s[0]), v=Integer.valueOf(s[1]), c=Integer.valueOf(s[2]);
                add(u,v,c);
                add(v,u,c);
                node uv=new node(u,v,c);
                road.add(uv);

            }

            //打印最短路径,更改各点之间的权值

            for (int i=0;i<n;i++) {
                spfamin(i);
//                for (int j=0;j<n;j++){
//                    System.out.print("从 "+i+" 到 "+j+" : ");
//                    print(path1[j],i,0);
//                    System.out.println();
//                    //print(path[i], j, 1); //max
//                }
            }

            for (int i=0;i<road.size();i++){
                int start=road.get(i).s, end= road.get(i).e, c=road.get(i).c;
                if (dis1[start][end] < c)
                    bw.write(i+"\n");
            }

        }

        bw.close();
        fw.close();
    }
}
