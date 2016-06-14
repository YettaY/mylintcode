package g_apac.Practice_Round_APAC_test_2016;

import java.io.*;
import java.util.*;

/**
 * 可以使用回溯法解决图的M着色问题，但是对个这个特殊的问题，可以使用 BFS解决。
 * 算法过程为：借助队列，进行宽度优先遍历，先对一个起点着色RED，然后将其所有相邻的节点着色为BLUE，并加入队列。
 * 只要能保证相邻的节点是不同的颜色即可。
 * */

/*     读写文件
        FileReader fr=new FileReader("small.in");
        BufferedReader br=new BufferedReader(fr);

        FileWriter fw=new FileWriter("small.out");
        BufferedWriter bw=new BufferedWriter(fw);

        FileOutputStream fo=new FileOutputStream("small.out");
        BufferedOutputStream bo=new BufferedOutputStream(fo);

        PrintWriter pw=new PrintWriter("small.out");

*/

public class Bad_Horse {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(new File("A-small-practice-1.in"));
        FileOutputStream fo=new FileOutputStream(new File("out1.txt"));
        int t=in.nextInt();
        for (int i=1;i<=t;i++){
            Map<String,Integer> map=new HashMap<>();
            int n=in.nextInt();
            int id=0;
            int[][] graph=new int[2*n][2*n];
            for (int j=0;j<n;j++){
                String s1=in.next();
                String s2=in.next();
                Integer a,b;
                if ((a=map.get(s1))==null){
                    a=id;
                    map.put(s1,id);
                    id++;
                }
                if ((b=map.get(s2))==null){
                    b=id;
                    map.put(s2,id);
                    id++;
                }
                graph[a][b]=1;
                graph[b][a]=1;
            }
            boolean f=isvalid(graph,id);
            String out="Case #"+i+": ";
            if (f)
                out+="Yes\n";
            else
                out+="No\n";
            fo.write(out.getBytes());
        }
        fo.close();
    }
    public static boolean isvalid(int[][] g,int n){
        int[] color=new int[n];  //第i个节点的颜色
        color[0]=1;
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()){
            int cur=q.poll();
            for (int i=0;i<n;i++){
                if (g[cur][i]==1 && color[i]==0) {
                    color[i] = 3 - color[cur];
                    q.offer(i);
                }
                else if (g[cur][i]==1 && color[i]==color[cur])
                    return false;
            }
        }
        return true;
    }
}
