package g_apac.Round_A_APAC_Test_2016;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 设位置k的字符是B[k]，k从1开始
 B[k]以下性质
 1. 处在2次幂位置的数必定为0
 2. 如果k是偶数，B[k]=B[k/2]
 3. 如果k是奇数，k=2i+1，B[k]=i%2
 */
public class Googol_String {
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("A-small-practice-1.in"));
        FileOutputStream fo=new FileOutputStream(new File("out1.txt"));
        int t=in.nextInt();
        for (int i=1;i<=t;i++){
            int k=Integer.valueOf(in.nextLine());
            if ((k&(k-1))==0)
                fo.write();
        }
    }
}
