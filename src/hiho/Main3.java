package hiho;
import java.util.*;
/**
 * Created by Administrator on 2016/8/7.
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),m = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        String[] w = line.split(" ");
        int[] cnt = new int[w.length];
        for (int i = 0; i < cnt.length; i++)
            cnt[i] = w[i].length();

        int row = 1,col = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < cnt.length;) {
                if ((m - col) >= cnt[j]) {
                    col = col + cnt[j];
                    j++;
                } else {
                    col = m - 1;
                }
                if (col == m) {
                    row += 1;
                    col = 1;
                } else if (col == m - 1) {
                    row += 1;
                    col = 0;
                } else {
                    col += 1;
                }
            }
            if (m - col < cnt[0] && i < n) {
                int a = n / i;
                i = a * i + 1;
                row = row * a + 1;
                col = 0;
            }
        }
        if (col == 0) {
            System.out.println((row-1) + " " + (m-1));
        } else if (col == 1) {
            System.out.println((row-1) + " " + (m));
        } else {
            System.out.println((row) + " " + (col - 1));
        }
    }
}
