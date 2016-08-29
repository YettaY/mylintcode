package g_apac.Round_B_APAC_Test_2017;

import java.io.*;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\B-small-attempt6.in"));
        int t = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\out.txt"));

        for (int id = 1; id <= t; id++) {
            long ans=0;
            String line = br.readLine();
            String[] str = line.split(" ");
            long A=Long.valueOf(str[0]), B=Long.valueOf(str[1]);
            long N=Long.valueOf(str[2]), K=Long.valueOf(str[3]);
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i!=j) {
                        long r = (pow(i, A) + pow(j, B));
                        if(r%K==0)
                            ans++;
                    }
                }
            }
            ans%=1000000007l;
            bw.write("Case #" + id + ": " + ans  + "\n");
        }
        br.close();
        bw.close();
    }
    public static long pow(long x, long n){
        if(n == 0)
            return 1;
        if(n<0)
            return (1 / (x * pow(x, -(n + 1))));
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
