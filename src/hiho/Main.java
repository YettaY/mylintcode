package hiho;
import java.util.*;
/**
 * Created by Administrator on 2016/8/7.
 */
public class Main {
    static private class node{
        int s,e,c;
        public node(int s,int e,int c){
            this.s=s;
            this.e=e;
            this.c=c;
        }
    }


    public static void dijkstra(int n, int v0, int[] dist, int[] path, int[][] map) //v0表示源顶点
    {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)     //初始化
        {
            if(map[v0][i]<Integer.MAX_VALUE && i!=v0)
            {
                dist[i] = map[v0][i];
                path[i] = v0;     //path记录最短路径上从v0到i的前一个顶点
            }
            else
            {
                dist[i] = Integer.MAX_VALUE;    //若i不与v0直接相邻，则权值置为无穷大
                path[i] = -1;
            }
            visited[i]=false;
            path[v0]=v0;
            dist[v0]=0;
        }
        visited[v0]=true;
        for(int i=1;i<n;i++)     //循环扩展n-1次
        {
            int min=Integer.MAX_VALUE;
            int u=0;
            for(int j=0;j<n;j++)    //寻找未被扩展的权值最小的顶点
            {
                if(visited[j]==false && dist[j]<min)
                {
                    min=dist[j];
                    u=j;
                }
            }
            visited[u]=true;
            for(int k=0;k<n;k++)   //更新dist数组的值和路径的值
            {
                if(visited[k]==false && map[u][k]<Integer.MAX_VALUE && min+map[u][k] < dist[k])
                {
                    dist[k]=min+map[u][k];
                    path[k]=u;
                }
            }
        }
    }

    public static String searchPath(int[] path,int v, int v0) //打印最短路径上的各个顶点
    {
        StringBuilder sb=new StringBuilder();
        Stack<Integer> s=new Stack<>();
        int u=v;
        while(v!=v0)
        {
            s.push(v);
            v=path[v];
        }
        s.push(v);

        while(!s.empty()) {

            if (s.size()>1)
                sb.append(s.pop() + "-");
            else
                sb.append(s.pop());

        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int n=in.nextInt(), m=in.nextInt();
            int[][] map=new int[n+m][n+m];
            for (int i = 0 ; i < n+m ; i++) {
                for (int j = 0 ; j < n+m; j++) {
                    map[i][j] = Integer.MAX_VALUE; // account for overflow
                }
                map[i][i] = 0;
            }
            for(int id=0,i=0;id<n-1;id++){
                int cur=in.nextInt();
                for(int j=0;j<m;j++){
                    int u=i*m+j, v=(i+1)*m+j;
                    map[u][v]=map[v][u]=cur;

                }
            }
        }
    }

}
