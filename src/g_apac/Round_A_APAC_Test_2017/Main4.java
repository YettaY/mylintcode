package g_apac.Round_A_APAC_Test_2017;


import java.util.Scanner;

public class Main4 {
    static class Card {
        int num;
        int[] Power, coin;
        int cur;
        public Card(int n,int cur) {
            this.num = n;
            this.Power = new int[n];
            this.coin = new int[n];
            this.cur=cur;
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int id = 1; id <= T; ++id) {
            int M = in.nextInt(), N = in.nextInt();
            Card[] cs = new Card[N];
            for (int i = 0; i < N; ++i) {
                int a = in.nextInt(), b = in.nextInt();

                cs[i] = new Card(a,b);
                int tmp = b;
//                while((--b) > 0)
//                    in.nextInt();

                for (int j = 0; j < cs[i].num; ++j)
                    cs[i].Power[j] = in.nextInt();

//                while((--tmp) > 0)
//                    in.nextInt();

                cs[i].coin[0] = 0;

                for (int j = 1; j < cs[i].num; ++j)
                    cs[i].coin[j] = cs[i].coin[j - 1] + in.nextInt();
            }
            int ans = fun(M, N, cs);
            System.out.println("Case #" + id + ": " + ans);

        }

    }
    static int fun(int M, int N, Card[] cs) {

        int[][] ans = new int[N][M + 1];
        ans[0][0] = cs[0].Power[0];
        for (int i = 1; i < N; ++i) {
            ans[i][0] = ans[i - 1][0] + cs[i].Power[cs[i].cur];
        }
        for (int i = 0; i <= M; ++i) {
            for (int j = 0; j < cs[0].num ; ++j) {
                if (i >= cs[0].coin[cs[0].num - 1]) {
                    ans[0][i] = cs[0].Power[cs[0].num - 1];
                    break;
                }
                if (i >= cs[0].coin[j] && i < cs[0].coin[j + 1]) {
                    ans[0][i] = cs[0].Power[j];
                }
            }
        }
        for (int k = 1; k <=N; ++k) {
            for (int v = 1; v <= M; ++v) {
                int max = 0;
                for (int i = 0; i < cs[k].num; ++i) {
                    if (v - cs[k].coin[i] >= 0) {
                        max = Math.max(max, ans[k - 1][v - cs[k].coin[i]] + cs[k].Power[i]);
                    }
                }
                ans[k][v] = max;
            }
        }

        return ans[N - 1][M];
    }

}