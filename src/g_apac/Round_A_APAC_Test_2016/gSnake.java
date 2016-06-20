package g_apac.Round_A_APAC_Test_2016;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * Created by yanglu on 16/6/19.
 */
public class gSnake {
    static class node{
        int x,y;
    }
    static class snake{
        node[] p=new node[1000005];
        int d, n, x, y;
    }

    public static snake a;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int m, r, c;
    static int[][] g;

    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("D-large-practice.in.txt"));
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int tcase=in.nextInt();
        for (int id=1;id<=tcase;id++){
            bw.write("Case #"+id+": ");

            m=in.nextInt();
            r=in.nextInt();
            c=in.nextInt();
            g=new int[105][105];
            for (int i=1;i<=r;i++)
                for (int j=1;j<=c;j++)
                    g[i][j]=(i+j)%2;

            int[] t=new int[1000005];
            char[] str=new char[5];
            for (int i=1;i<=m;i++){
                int x=in.nextInt();
                str=in.next().toCharArray();
                if (str[0]=='R')
                    t[x]=1;
                else
                    t[x]=3;

            }

            a=new snake();
            for (int i=0;i<a.p.length;i++)
                a.p[i]=new node();
            a.x=a.y=1;
            a.n=1;
            a.d=0;
            a.p[1].x=a.p[1].y=1;
            for (int i=1;i<=20000;i++) {
                int k = move();
                if (k == 0)
                    break;
                a.d = (a.d + t[i]) % 4;
            }
            bw.write(a.n+"\n");
        }
        bw.close();
        fw.close();
    }
    public static int move(){
        int nx=a.x+dx[a.d];
        int ny=a.y+dy[a.d];
        if (nx==0)
            nx=r;
        if (nx>r)
            nx=1;
        if (ny==0)
            ny=c;
        if (ny>c)
            ny=1;
        if (g[nx][ny]==0){
            for(int i=1;i<a.n;i++){
                a.p[i]=a.p[i+1];
                if(a.p[i].x==nx && a.p[i].y==ny)
                    return 0;
            }
            a.p[a.n].x=nx;
            a.p[a.n].y=ny;
        }
        if(g[nx][ny]==1){
            for(int i=1;i<=a.n;i++){
                if(a.p[i].x==nx && a.p[i].y==ny)
                    return 0;
            }
            ++a.n;
            a.p[a.n].x=nx;a.p[a.n].y=ny;
            g[nx][ny]=0;
        }
        a.x=nx;a.y=ny;
        return 1;
    }
}
