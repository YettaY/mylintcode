package graph;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2016/6/18.
 */
public class Dijkstra {
    public static List<String> road=new ArrayList<>();
    public static Set<Integer> set=new HashSet<Integer>();


    public static void dijkstra(int n, int v0, int[] dist, int[] path, int[][] map) //v0表示源顶点
    {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)     //初始化
        {
            if(map[v0][i]>0 && i!=v0)
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
                if(visited[k]==false && map[u][k]>0 && min+map[u][k] < dist[k])
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
        int a=-1,b=-1;
        if (!s.isEmpty())
            a=s.pop();
        while(!s.empty()) {
            b=s.peek();
            for (int i=0;i<road.size();i++){

                String ab= new String(a+"-" +b), ba=new String(b+"-" +a);
                if ( road.get(i).equals(ab) || road.get(i).equals(ba)) {
                    if (a==6 && b==74 )
                        System.out.println(v0+ " " +v);
                    if (!set.contains(i))
                        set.add(i);
                    break;
                }
            }

            if (s.size()>1)
                sb.append(s.pop() + "-");
            else
                sb.append(s.pop());

            a=b;
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
            road.clear();
            set.clear();
            System.out.println("Case #"+id+":");
            bw.write("Case #"+id+":\n");
            String[] s=in.nextLine().split(" ");

            int n=Integer.valueOf(s[0]), m=Integer.valueOf(s[1]);
            int[][] map=new int[n][n];


            for (int j=0;j<m;j++){
                s=in.nextLine().split(" ");
                int u=Integer.valueOf(s[0]), v=Integer.valueOf(s[1]), c=Integer.valueOf(s[2]);
                String uv=new String(s[0]+"-"+s[1]), vu=new String(s[1]+"-"+s[0]);
             //   System.out.println(uv+"   "+vu);
                if (!road.contains(uv) && !road.contains(vu))
                    road.add(uv);

                map[u][v]=c;
                map[v][u]=c;
            }


            int[] dist=new int[n]; // 表示当前点到源点的最短路径长度
            int[] prev=new int[n]; // 记录当前点的前一个结点


            for (int i=0;i<n;i++){
          //      System.out.println(i+" 为源点");
                dijkstra(n, i, dist, prev, map);
                for (int j=0;j<n;j++){
                    if (j!=i) {
           //             System.out.println(i+" 到 "+j+" 距离为："+dist[j]);
                        String p=searchPath(prev, j, i);
           //             System.out.println(p);
                    }
                }

            }



            for (int i=0;i<road.size();i++){
                if (!set.contains(i)){
         //           System.out.println(i);
                    bw.write(i+"\n");
                }
            }

        }

        bw.close();
        fw.close();
    }
}
