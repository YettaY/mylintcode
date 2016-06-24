package graph;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 有负权回路则不行，用spfa
 *
 * g_apac.Round_A_APAC_Test_2016的gCampus题
 * 也可以用dijkstra算法实现, dijkstra是求单元点对的最短路径,遍历n次该算法就能求出所有点对的最短路径
 * 其他步骤同gCampus的floyd算法实现
 * 注意:map[i][i]=0, road(start,end)中若start=end,并且时间大于0的时候不能更新map[i][i]
 * 如可能出现 0 0 1 的路径,此时map[0][0]依旧为0,不能赋值为1
 */
public class Dijkstra {

    static class node{
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

    public static void main(String[] args)throws IOException{
        Scanner in=new Scanner(new File("C-large-practice.in"));//C-small-practice.in
        FileWriter fw=new FileWriter("out1.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int t=Integer.valueOf(in.nextInt());
        in.nextLine();//截取回车\r

        for (int id=1;id<=t;id++){

            bw.write("Case #"+id+":\n");
            String[] s=in.nextLine().split(" ");

            int n=Integer.valueOf(s[0]), m=Integer.valueOf(s[1]);
            int[][] map=new int[n][n];
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    map[i][j] = Integer.MAX_VALUE; // account for overflow
                }
                map[i][i] = 0;
            }
            List<node> road=new ArrayList<>();

            for (int j=0;j<m;j++){
                s=in.nextLine().split(" ");
                int u=Integer.valueOf(s[0]), v=Integer.valueOf(s[1]), c=Integer.valueOf(s[2]);
                node uv=new node(u,v,c);
                road.add(uv);


                if (map[u][v]>c) {
                    map[u][v] = c;
                    map[v][u] = c;
                }
            }


            int[] dist=new int[n]; // 表示当前点到源点的最短路径长度
            int[] prev=new int[n]; // 记录当前点的前一个结点

            //打印最短路径,更改各点之间的权值

            for (int i=0;i<n;i++){
     //         System.out.println(i+" 为源点");
     //           bw.write(i+" 为源点"+"\n");
                dijkstra(n, i, dist, prev, map);
                for (int j=0;j<n;j++){
                    if (j!=i) {
    //                 bw.write(i + " 到 " + j + " 距离为：" + dist[j]+"\n");
    //                 System.out.println(i + " 到 " + j + " 距离为：" + dist[j]);
    //                  String p = searchPath(prev, j, i);
    //                  System.out.println(p);
     //                 bw.write(p+"\n");
                        map[i][j] = dist[j];
                    }
                }
            }

            for (int i=0;i<road.size();i++){
                int start=road.get(i).s, end= road.get(i).e, c=road.get(i).c;
                if (map[start][end] < c)
                    bw.write(i+"\n");
            }

        }

        bw.close();
        fw.close();
    }
}
