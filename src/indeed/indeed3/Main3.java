package indeed.indeed3;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rn = in.nextInt(), cn = in.nextInt();

        char[][] table = new char[rn][cn];
        for (int i = 0; i < rn; i++) {
            String str = in.next();
            for (int j = 0; j < cn; j++) {
                table[i][j] = str.charAt(j);
            }
        }

        double[][] square = getsquare(table);

        double r = 0.0;
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                r += square[i][j];
            }
        }

        System.out.print(String.format("%.15f", r));
    }

    private static double[][] getsquare(char[][] t) {
        int rn = t.length, cn = t[0].length;
        double[][] kn = new double[rn][cn];
        int x = 0, y = 0;
        kn[x][y] = 1;
        for (y = 1; y < cn; y++) {
            switch (t[x][y-1]) {
                case 'R':
                    kn[x][y] = 0;
                    break;
                case 'C':
                    kn[x][y] = 1;
                    break;
                case '?':
                    kn[x][y] = 0.5;
                    break;
            }
        }
        y = 0;
        for (x = 1; x < rn; x++) {
            switch (t[x-1][y]) {
                case 'R':
                    kn[x][y] = 1;
                    break;
                case 'C':
                    kn[x][y] = 0;
                    break;
                case '?':
                    kn[x][y] = 0.5;
                    break;
            }
        }

        for (x = 1; x < rn; x++) {
            for (y = 1; y < cn; y++) {
                if (t[x-1][y] == 'C' || t[x][y-1] == 'R') {
                    kn[x][y] = 0;
                } else if (t[x-1][y] == 'R' && t[x][y-1] == 'C') {
                    kn[x][y] = 1;
                } else if (t[x-1][y] == '?' && t[x][y-1] == '?') {
                    kn[x][y] = 0.25;
                } else {
                    kn[x][y] = 0.5;
                }
            }
        }
        return kn;
    }
}