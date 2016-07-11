package g_apac.Round_A_APAC_Test_2017;

import java.math.BigDecimal;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tn = in.nextInt();
        int[] c = new int[tn];
        int[][] pro = new int[tn][];
        for (int i = 0; i < tn; i++) {
            int mon = in.nextInt();
            pro[i] = new int[mon];
            c[i] = in.nextInt();
            for (int j = 0; j < mon; j++) {
                pro[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < tn; i++) {
            double irr = rec(c[i], pro[i], -1, 1);
            System.out.println(String.format("Case #%d: %.12f", i+1, irr));
        }
    }


    private static double rec(int c, int[] pro, double lR, double rR) {
        if (rR - lR < 0.000000000001) {
            return lR;
        }

        double mid = (lR + rR) / 2;
        BigDecimal midResult = computefun(c, pro, mid);
        int cmp = midResult.compareTo(new BigDecimal(0.0));
        if (cmp == 0) {
            return mid;
        } else if (cmp == 1) {
            return rec(c, pro, mid, rR);
        } else {
            return rec(c, pro, lR, mid);
        }
    }

    private static BigDecimal computefun(int c, int[] pro, double r) {
        int mon = pro.length;

        BigDecimal mul = new BigDecimal(1+r);
        BigDecimal ans = mul.pow(mon).multiply(new BigDecimal(c)).negate();
        for (int i = mon - 1; i >= 0; i--) {
            ans = ans.add(mul.pow(mon - i - 1).multiply(new BigDecimal(pro[i])));
        }

        return ans;
    }
}
