package g_apac.Round_B_APAC_Test_2016;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Travel {

    private static class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair<?, ?> p = (Pair<?, ?>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
        }
    }

    static int n, m ,k;
    static int[][] d,w,ans;
    static boolean[][] inq;
    static int[] u, v;
    static int[] fir, nex;
    static int cnt;

    private static void add(int a, int b, int[] c){
        u[cnt] = a;
        v[cnt] = b;
        for(int i=0;i<24;i++)
            w[cnt][i] = c[i];
        nex[cnt] = fir[u[cnt]];
        fir[u[cnt]] = cnt ++;
    }

    public static void spfamin(int t){ //最短路
        boolean[][] vis=new boolean[n+2][24];
        Queue<Pair> q=new LinkedList<>();

        for(int i = 1; i <= n; ++i)
            for (int j=0;j<24;j++)
                d[i][j] = Integer.MAX_VALUE;

        q.offer(new Pair(1,t));
        vis[1][t] = true;
        d[1][t] = 0;

        while( !q.isEmpty() ){
            Pair cur = q.poll();
            int u=(int)cur.first, time=(int)cur.second;
            vis[u][time] = false;

            int k = fir[u];
            while(k != -1){
                int b = v[k], c = w[k][time];
                int nxt = (time + c) % 24;

                if(d[b][nxt] > d[u][time] + c){
                    d[b][nxt] = d[u][time] + c;
                    if(!vis[b][nxt]){
                        vis[b][nxt] = true;
                        q.offer(new Pair(b,nxt));
                    }
                }
                k = nex[k];
            }
        }
        for ( int i = 1; i <= n; i ++ ) {
            ans[t][i] = Integer.MAX_VALUE;
            for ( int j = 0; j < 24; j ++ ) {
                ans[t][i] = Math.min( ans[t][i], d[i][j] );
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("in.txt"));
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int tcase=in.nextInt();

        for (int id=1;id<=tcase;id++){
            bw.write("Case #"+id+": ");
            int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();

            d=new int[510][24];
            w=new int[510][24];
            ans=new int[24][510];

            u=new int[2005];
            v=new int[2005];
            fir=new int[2005];
            nex=new int[2005];

            Arrays.fill(fir, -1);
            cnt=0;
            for (int i=0;i<m;i++){
                int u=in.nextInt(), v=in.nextInt();

                int[] cost=new int[24];
                for (int j=0;j<24;j++)
                    cost[j] = in.nextInt();

                add(u,v,cost);
                add(v,u,cost);
            }
            for (int i=0 ;i<24; i++)
                spfamin(i);
            for (int i=0;i<k;i++){
                int des=in.nextInt(), s=in.nextInt();
                int ret= (ans[s][des]==Integer.MAX_VALUE) ? -1:ans[s][des];
                bw.write(ret+" ");
            }
            bw.write("\n");
        }
        bw.close();
        fw.close();

    }
}
