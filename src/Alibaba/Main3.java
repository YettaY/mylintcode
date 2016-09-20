package Alibaba;

/**
 * Created by yanglu on 16/9/19.
 */
import java.util.*;

public class Main3{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int id=0;id<t;id++){
            int n=in.nextInt(), m=in.nextInt();
            int[][] a=new int[n][m];
            for(int i=0;i<n;i++)
                for(int j=0;j>m;j++)
                    a[i][j]=in.nextInt();

        }
    }
    public boolean first(int[][] a, int x, int y, int len){
        for(int i=x;i<a.length && i-x<=len;i++){
            if(a[i][y]==0)
                return false;
            if(y+len<a[0].length)
                if(a[i][y+len]==0)
                    return false;

        }
        for(int j=y;j<a[0].length && j-y<=len;j++){
            if(a[x][j]==0)
                return false;
            if(x+len<a.length)
                if(a[x+len][j]==0)
                    return false;
        }
        return true;
    }
    public boolean second(int[][] a, int x, int y, int len){
        for(int i=1;i<=len;i++){
            if(i+x<a.length && i+y<a[0].length)
                if(a[i+x][i+y]==0)
                    return false;
            if(i+x<a.length && y-i>=0)
                if(a[i+x][y-i]==0)
                    return false;
        }
        if(x+2*len>=a.length)
            return false;

        return true;
    }

}