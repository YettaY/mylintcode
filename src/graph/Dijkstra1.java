package graph;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * g_apac.Round_A_APAC_Test_2016的gCampus题
 * 也可以用dijkstra算法实现, dijkstra是求单元点对的最短路径,遍历n次该算法就能求出所有点对的最短路径
 * 其他步骤同gCampus的floyd算法实现
 * 注意:map[i][i]=0, road(start,end)中若start=end,并且时间大于0的时候不能更新map[i][i]
 * 如可能出现 0 0 1 的路径,此时map[0][0]依旧为0,不能赋值为1
 */
public class Dijkstra1 {

    static class node{
        int s,e,c;
        public node(int s,int e,int c){
            this.s=s;
            this.e=e;
            this.c=c;
        }
    }


    public static void dijkstra(int n, int v, int[] dist, int[] prev, int[][] c) //v0表示源顶点
    {
        boolean[] s=new boolean[n];    // 判断是否已存入该点到S集合中
        for(int i=0; i<n; ++i)
        {
            dist[i] = c[v][i];
            s[i] = false;     // 初始都未用过该点
            if(dist[i] == Integer.MAX_VALUE)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;

        // 依次将未放入S集合的结点中，取dist[]最小值的结点，放入结合S中
        // 一旦S包含了所有V中顶点，dist就记录了从源点到所有其他顶点之间的最短路径长度
        for(int i=1; i<n; ++i)
        {
            int tmp = Integer.MAX_VALUE;
            int u = v;
            // 找出当前未使用的点j的dist[j]最小值
            for(int j=0; j<n; ++j)
                if((!s[j]) && dist[j]<tmp)
                {
                    u = j;              // u保存当前邻接点中距离最小的点的号码
                    tmp = dist[j];
                }
            s[u] = true;    // 表示u点已存入S集合中

            // 更新dist
            for(int j=0; j<n; ++j)
                if((!s[j]) && c[u][j]<Integer.MAX_VALUE)
                {
                    int newdist = dist[u] + c[u][j];
                    if(newdist < dist[j])
                    {
                        dist[j] = newdist;
                        prev[j] = u;
                    }
                }
        }
    }

    public static String searchPath(int[] prev,int v, int u) //打印最短路径上的各个顶点
    {
        int[] que=new int[prev.length];
        int tot = 0;
        que[tot] = u;
        tot++;
        int tmp = prev[u];
        while(tmp != v)
        {
            que[tot] = tmp;
            tot++;
            tmp = prev[tmp];
        }
        que[tot] = v;
        StringBuffer sb=new StringBuffer();
        for(int i=tot; i>=0; --i)
            if(i != 0)
                sb.append(que[i]+"->");
            else
                sb.append(que[i]+"\n");
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
                    map[i][j] = Integer.MAX_VALUE;
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
       //         bw.write(i+" 为源点"+"\n");
                dijkstra(n, i, dist, prev, map);
                for (int j=0;j<n;j++){
                    if (j!=i) {
       //                 bw.write(i + " 到 " + j + " 距离为：" + dist[j]+"\n");
       //                 System.out.println(i + " 到 " + j + " 距离为：" + dist[j]);
       //                 String p = searchPath(prev, i, j);
       //                 System.out.println(p);
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
