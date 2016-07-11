package g_apac.Round_A_APAC_Test_2017;

import java.io.*;
import java.util.*;

public class Main2 {
    static class node {
        int i;
        int j;
        int h;

        public node(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/yanglu/Downloads/B-large.in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("b2"));
        int t = Integer.valueOf(br.readLine());
        int id = 1;
        for (int i = 0; i < t; i++) {
            String[] len = br.readLine().split(" ");
            int r = Integer.valueOf(len[0]);
            int c = Integer.valueOf(len[1]);
            int[][] g = new int[r][c];
            for (int j = 0; j < r; j++) {
                String[] str = br.readLine().split(" ");
                for (int k = 0; k < c; k++) {
                    g[j][k] = Integer.valueOf(str[k]);
                }
            }
            bw.write("Case #" + id++ + ": " + trw(g) + "\n");
        }
        br.close();
        bw.close();
    }

    public static int trw(int[][] g) {
        if(g.length == 0 || g[0].length == 0)
            return 0;
        int m = g.length, n = g[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<node> minq = new PriorityQueue<>(10, new Comparator<node>() {
            public int compare(node c1, node c2) {
                return c1.h - c2.h;
            }
        });

        for(int i=0; i<m; i++) {
            minq.add(new node(i, 0, g[i][0]));
            minq.add(new node(i, n-1, g[i][n-1]));
        }
        for(int j=0; j<n; j++) {
            minq.add(new node(0, j, g[0][j]));
            minq.add(new node(m-1, j, g[m-1][j]));
        }

        while(!minq.isEmpty()) {
            node c = minq.poll();
            vis[c.i][c.j] = true;

            ans += cal(minq, g, vis, c.i + 1, c.j, c.h);
            ans += cal(minq, g, vis, c.i - 1, c.j, c.h);
            ans += cal(minq, g, vis, c.i, c.j + 1, c.h);
            ans += cal(minq, g, vis, c.i, c.j - 1, c.h);
        }

        return ans;
    }

    private static int cal(PriorityQueue<node> minq, int[][] H, boolean[][] vis, int i, int j, int cur) {
        int m = H.length, n = H[0].length;
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j])  return 0;

        vis[i][j] = true;
        minq.add(new node(i, j, Math.max(cur, H[i][j])));
        return Math.max(0, cur - H[i][j]);
    }


}