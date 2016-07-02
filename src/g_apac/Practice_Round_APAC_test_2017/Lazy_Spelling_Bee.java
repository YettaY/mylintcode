package g_apac.Practice_Round_APAC_test_2017;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Administrator on 2016/6/26.
 */
public class Lazy_Spelling_Bee {
    public static void main(String[] args)throws IOException {
        Scanner in = new Scanner(new File("A-small-attempt0.in"));//A-small-attempt0.in
        FileWriter fw = new FileWriter("out1.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int t=in.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        BigInteger modv=new BigInteger("1000000007");
        BigInteger two=new BigInteger("2");
        for (int id=1;id<=t;id++){
            bw.write("Case #"+id+": ");
            String s=in.next();
            BigInteger ans=BigInteger.ONE;
            for (int i=1;i<s.length()-1;i++) {
                int c=1;
                if (s.charAt(i-1)!=s.charAt(i))
                    c++;
                if (s.charAt(i+1)!=s.charAt(i-1) && s.charAt(i+1)!=s.charAt(i))
                    c++;

                ans=ans.multiply(BigInteger.valueOf(c));
                ans=ans.mod(modv);
            }
            if (s.length()>1 && s.charAt(0)!=s.charAt(1))
                ans=ans.multiply(BigInteger.valueOf(2));
            if (s.length()>1 && s.charAt(s.length()-1)!=s.charAt(s.length()-2))
                ans=ans.multiply(BigInteger.valueOf(2));
            ans=ans.mod(modv);
            bw.write(ans+"\n");
        }
        bw.close();
        fw.close();
    }
}
