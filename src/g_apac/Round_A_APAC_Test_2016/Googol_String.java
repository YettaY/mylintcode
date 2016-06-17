package g_apac.Round_A_APAC_Test_2016;

import java.io.*;
import java.util.Scanner;

/**
 *  Let L(i) denote the length for the string Si.
 *  L(0) = 0, L(1) =1, L(i) = 2*L(i-1) + 1.
 *  If we continue the recursive relation L(i) = 2*L(i-1) +1 until to S(0),
 *  we have L(i)= 2^i - 1.
 * 设位置k的字符是B[k]，k从1开始
 B[k]以下性质
 1. 处在2次幂位置的数必定为0
 2. 如果k是偶数，B[k]=B[k/2]
 3. 如果k是奇数，k=2i+1，B[k]=i%2
 */
public class Googol_String {
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("A-large-practice.in"));

        FileWriter fw=new FileWriter("out1.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int t=in.nextInt();
        for (int i=1;i<=t;i++){
            long k=in.nextLong();
            if ((k&(k-1))==0)
                k=0;
            else{
                while(k>0 && ((k & 1) == 0))
                    k >>= 1;
                k >>= 1;
                k &= 1;
            }
            fw.write("Case #"+i+": "+ k +"\n");
        }
        bw.close();
        fw.close();
    }
}
