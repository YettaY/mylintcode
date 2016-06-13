package g_apac;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/13.
 */
public class Bad_Horse {
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader("small.in");
        BufferedReader br=new BufferedReader(fr);

        FileWriter fw=new FileWriter("small.out");
        BufferedWriter bw=new BufferedWriter(fw);

        FileOutputStream fo=new FileOutputStream("small.out");
        BufferedOutputStream bo=new BufferedOutputStream(fo);

        PrintWriter pw=new PrintWriter("small.out");

        int t=Integer.valueOf(br.readLine());

        for (int i=1;i<=t;i++) {
            int m=Integer.valueOf(br.readLine());
            Set<String> set1=new HashSet<>();
            Set<String> set2=new HashSet<>();
            for (int j=0;j<m;j++){
                String line=br.readLine();
                String[] s = line.split(" ");
                if (!set1.contains(s[0]) && !set2.contains(s[0])) {
                    set1.add(s[0]);
                    if (!set2.contains(s[1]))
                        set2.add(s[1]);
                } else if (set1.contains(s[0])) {
                    if (set1.contains(s[1])) {
                        bw.write("Case #"+i+":No\n");
                        break;
                    }
                    if(!set2.contains(s[1]))
                        set2.add(s[1]);
                }else if (set2.contains(s[0])) {
                    if (set2.contains(s[1])) {
                        bw.write("Case #"+i+":No\n");
                        break;
                    }
                    if(!set1.contains(s[1]))
                        set1.add(s[1]);
                }
            }
            bw.write("Case #"+i+":Yes\n");
        }
    }
}
