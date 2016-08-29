package g_apac.Round_B_APAC_Test_2017;

import java.io.*;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\A-large.in"));
        int t = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\out1.txt"));

        for (int id = 1; id <= t; id++) {
            String ll = br.readLine();
            String[] str = ll.split(" ");
            int L=Integer.valueOf(str[0]), R=Integer.valueOf(str[1]);
            int min=Math.min(L, R);
            long ans = (min*min + min)/2;
            bw.write("Case #" + id + ": " + ans + "\n");
        }
        br.close();
        bw.close();
    }
}