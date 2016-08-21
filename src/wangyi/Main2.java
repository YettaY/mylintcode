package wangyi;

import java.util.Scanner;

/**
 * 左上角和右下角是0,有1的不能过,求问是否能从左上角到右下角,四个方向
 5
 0 1 1 1 0
 0 0 0 1 1
 1 1 0 0 0
 1 1 1 0 1
 0 0 0 0 0
 * Created by yanglu on 16/8/2.
 */
import java.util.*;

public class Main2
{
    static int to[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int map_f[][];
    static int map[][];
    static int n;
    static public void dfs(int i, int j)
    {
        int x,y,k;
        map_f[i][j] = 1;
        map[i][j] = 1;
        for(k = 0;k<4;k++)
        {
            x = i+to[k][0];
            y = j+to[k][1];
            if(x>=0 && y>=0 && x<n && y<n && map[x][y]==0)
                dfs(x,y);
        }
        return ;

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];
        map_f = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map[i][j] = in.nextInt();
            }
        }
        dfs(0,0);

        System.out.println(map_f[n-1][n-1] == 1 ? "Success!" : "Failure!");
    }

}