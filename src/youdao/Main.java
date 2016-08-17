package youdao;

import java.util.*;

public class Main
{


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int k = 0; k < num; k++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] n1 = new int[ n+1 ];
            int[] n2 = new int[ n+1 ];
            int[] nn = new int[ 2*n + 1];
            for(int i = 0; i < n; i++)
            {
                n1[i+1] = in.nextInt();
            }
            for(int i = 0; i < n; i++)
            {
                n2[i+1] = in.nextInt();
            }
            for(int i = 0; i < m; i++)
            {
                for(int j = 1; j <= n; j++)
                {
                    nn[2 * j - 1] = n1[j];
                }
                for(int j = 1; j <= n; j++)
                {
                    nn[2 * j] = n2[j];
                }
                for(int j = 1; j <= n; j++)
                {
                    n1[j] = nn[j];
                }
                for(int j = 1; j <= n; j++)
                {
                    n2[j] = nn[j+n];
                }
            }
            for(int i = 1; i <= 2 * n ;i++)
            {
                System.out.print(nn[i]);
                System.out.print(i == (2*n)? "\n":" ");
            }
        }

    }

}