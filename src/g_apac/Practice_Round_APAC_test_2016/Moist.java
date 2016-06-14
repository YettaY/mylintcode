package g_apac.Practice_Round_APAC_test_2016;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 类似插入排序，统计插入的次数。
 */
public class Moist {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("C-small-practice-2.in"));

        FileWriter fw = new FileWriter("out1.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        int t=Integer.valueOf(in.nextLine());
        for (int i=1;i<=t;i++){
            int n=Integer.valueOf(in.nextLine());
            List<String> s=new ArrayList<>();
            int ans=0;
            for (int j=0;j<n;j++)
                s.add(in.nextLine());
            for (int j=1;j<s.size();j++){
                if (s.get(j).compareToIgnoreCase(s.get(j-1))<0){
                    s.remove(j);
                    --j;
                    ans++;
                }
            }
            fw.write("Case #" + i + ": "+ans+"\n");
        }
        bw.close();
        fw.close();
    }
}
