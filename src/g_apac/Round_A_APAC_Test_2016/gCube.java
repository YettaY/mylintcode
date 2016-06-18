package g_apac.Round_A_APAC_Test_2016;

import java.io.*;
import java.util.Scanner;

/**
 * [L,R]区间各边相乘再开根号.
 */
public class gCube {
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("B-large-practice.in"));
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int t=Integer.valueOf(in.nextInt());
        in.nextLine();//截取回车\r

        for (int i=1;i<=t;i++){
            bw.write("Case #"+i+":\n");

            String[] s=in.nextLine().split(" ");
            int n=Integer.valueOf(s[0]), m=Integer.valueOf(s[1]);

            int[] nlen=new int[n];
            s=in.nextLine().split(" ");
            for (int j=0;j<n;j++)
                    nlen[j] = Integer.parseInt(s[j]);

            for (int j=0;j<m;j++){
                s=in.nextLine().split(" ");
                int l = Integer.valueOf(s[0]), r = Integer.valueOf(s[1]);
                int d = r-l+1;
                double ans=1.0;
                for (int k=l;k<=r;k++)
                    ans *= Math.pow(nlen[k], 1.0/d);
                bw.write(ans+"\n");
            }
        }
        bw.close();
        fw.close();
    }
}
