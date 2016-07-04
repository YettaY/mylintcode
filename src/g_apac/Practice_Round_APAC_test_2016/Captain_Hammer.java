package g_apac.Practice_Round_APAC_test_2016;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * V*sinx = 1/2 * g * t
 * V*cosx * t = D
 * =>x = 1/2* arcsin(gD/v^2)
 * 推出公式，sin2θ = G*D/(V*V)，我们需要求出θ（0<=θ<=π/2）
 * 需要用二分求，直接用θ的表达式会出现精度问题。
 */
public class Captain_Hammer {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(new File("in.txt"));

        FileWriter fw=new FileWriter("out1.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int t=in.nextInt();
        double pi = 4.0*Math.atan(1.0);
        double eps = 1e-10;

        for (int i=1;i<=t;i++){
            int v = in.nextInt();
            int d = in.nextInt();
            double l = 0.0, r = pi/2.0, m = (9.8*d)/(v*v), ans = 0.0;
            while(r-l >= eps) {
                double mid = (l+r)/2.0;
                if (2.0*mid <= pi/2.0){
                    if (Math.sin(2*mid) >= m)
                        r=mid;
                    else
                        l=mid;
                }
                else{
                    if (Math.sin(2*mid) >= m)
                        l=mid;
                    else
                        r=mid;
                }
                ans = mid;
            }
            ans = ans*180/pi;

            fw.write("Case #" + i + ": "+ans+"\n");
        }
        bw.close();
        fw.close();
    }
}
