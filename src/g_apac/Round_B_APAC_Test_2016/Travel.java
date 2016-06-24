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
    static class edge {
        int v;
        int[] cost=new int[24];
    }
    static int n, m ,k;
    static edge[] node=new edge[n];
    static int[][] dist=new int[n][24];
    static boolean[][] inq=new boolean[n][24];

    public static void spfa() {
        Arrays.fill(dist, -1);
        Arrays.fill(inq, false);

    }
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("D-large-practice.in.txt"));
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int tcase=in.nextInt();

        for (int id=1;id<=tcase;id++){
            bw.write("Case #"+id+": ");
            int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();


            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {

                }

            }

            for (int i=0;i<2*m;i+=2){
                int u=in.nextInt(), v=in.nextInt();

                int[] cost=new int[24];
                for (int j=0;j<24;j++)
                    cost[j] = in.nextInt();
                if (u!=v){
                    String uv = new String(u+"-"+v), vu = new String(v+"-"+u);

                }
            }
            for (int i=0;i<k;i++){
                int d=in.nextInt(), s=in.nextInt();

                bw.write("\n");
            }
        }
        bw.close();
        fw.close();

    }
}
