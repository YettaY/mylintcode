package g_apac.Round_A_APAC_Test_2016;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2016/6/18.
 */
public class gCampus {
    public static Map<Integer,int[]> road=new HashMap<>();
    public static Set<Integer> set=new HashSet<>();

    public static int[] dijkstra(int[][] weight, int start) {
        //接受一个有向图的权重矩阵，和一个起点编号start（从0编号，顶点存在数组中）
        //返回一个int[] 数组，表示从start到它的最短路径长度
        int n = weight.length;      //顶点个数
        int[] shortPath = new int[n];  //保存start到其他各点的最短路径
        String[] path = new String[n];  //保存start到其他各点最短路径的字符串表示
        for(int i=0;i<n;i++)
            path[i]=new String(start+"-"+i);
        int[] visited = new int[n];   //标记当前该顶点的最短路径是否已经求出,1表示已求出

        //初始化，第一个顶点已经求出
        shortPath[start] = 0;
        visited[start] = 1;

        for(int count = 1; count < n; count++) {   //要加入n-1个顶点
            int k = -1;        //选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                if(visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];
                    k = i;
                }
            }

            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = dmin;
            visited[k] = 1;

            //以k为中间点，修正从start到未访问各点的距离
            for(int i = 0; i < n; i++)
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "-" + i;

                }
        }
        for(int i = 0; i < n; i++) {
            System.out.println("从"+start+"出发到"+i+"的最短路径为："+path[i]);
            String[] s=path[i].split("-");
            int u=start,v=start;
            for (int j=1;j<s.length;j++){
                v=Integer.valueOf(s[j]);
                for (Integer key : road.keySet()) {
                    int[] uv=road.get(key);
                    if ((uv[0]==u && uv[1]==v) || (uv[0]==v && uv[1]==u)) {
                        if (!set.contains(key))
                            set.add(key);
                        break;
                    }
                }
                u=v;
            }
        }
     //   System.out.println("=====================================");
        return shortPath;
    }

    public static void main(String[] args)throws IOException{
        Scanner in=new Scanner(new File("in.txt"));
        FileWriter fw=new FileWriter("out.txt");
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

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (i!=j)
                        map[i][j]=Integer.MAX_VALUE;
                }
            }

            for (int j=0;j<m;j++){
                s=in.nextLine().split(" ");
                int u=Integer.valueOf(s[0]), v=Integer.valueOf(s[1]), c=Integer.valueOf(s[2]);
                road.put(j,new int[]{u,v});
                map[u][v]=map[v][u]=c;
            }

            for (int i=0;i<n;i++){
                int[] w=dijkstra(map,i);
            }
            for (int i=0;i<m;i++){
                if (!set.contains(i)){
                    System.out.println(i);
                    bw.write(i+"\n");
                }
            }
        }

        bw.close();
        fw.close();
    }
}
