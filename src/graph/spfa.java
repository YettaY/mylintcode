package graph;
import java.util.*;
/**
 * Created by Administrator on 2016/6/22.
 */
public class spfa {
    static int n, m, k;
    static int[] u=new int[2005], v=new int[2005], w=new int[2005];
    static int[] fir=new int[2005], nex=new int[2005];
    static int cnt;
    static int[][] path=new int[20005][20050], path1=new int[20005][20050];
    static int[][] dis=new int[20005][20050], dis1=new int[20005][20050];
    public static void add(int a, int b, int c){
        u[cnt] = a;
        v[cnt] = b;
        w[cnt] = c;
        nex[cnt] = fir[u[cnt]];
        fir[u[cnt]] = cnt ++;
    }
    public static void spfamax(int s){ //最长路
        boolean[] vis=new boolean[20005];
        for(int i = 0; i <= n; ++i) dis[s][i] = 0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(s); vis[s] = true; dis[s][s] = 0;
        while( !q.isEmpty() ){
            int a = q.front(); q.pop(); vis[a] = 0;
            int k = fir[a];
            while(k != -1){
                int b = v[k], c = w[k];
                if(dis[s][b] < dis[s][a] + c){
                    dis[s][b] = dis[s][a] + c;
                    path[s][b] = a;
                    if(!vis[b]){
                        vis[b] = 1;
                        q.push(b);
                    }
                }
                k = nex[k];
            }
        }
    }
   public static void spfamin(int s){ //最短路
        bool vis[1005]={0};
        queue<int>q;
        for(int i = 0; i <= n; ++i) dis1[s][i] = 0xfffffff;
        q.push(s); vis[s] = 1; dis1[s][s] = 0;
        while( !q.empty() ){
            int a = q.front(); q.pop(); vis[a] = 0;
            int k = fir[a];
            while(k != -1){
                int b = v[k], c = w[k];
                if(dis1[s][b] > dis1[s][a] + c){
                    dis1[s][b] = dis1[s][a] + c;
                    path1[s][b] = a;
                    if(!vis[b]){
                        vis[b] = 1;
                        q.push(b);
                    }
                }
                k = nex[k];
            }
        }
    }
}
