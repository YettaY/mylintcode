package g_apac.Round_A_APAC_Test_2017;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/yanglu/Downloads/A-large.in.txt"));
        int t = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new FileWriter("a2"));
        int id = 1;
        for (int i = 0; i < t; i++) {
            int line = Integer.valueOf(br.readLine());
            String[] str = new String[line];
            for (int j = 0; j < line; j++) {
                str[j] = br.readLine();
            }
            bw.write("Case #" + id++ + ": " + fun(str) + "\n");
        }
        br.close();
        bw.close();
    }
    public static String fun(String[] in) {
        int maxn = 0;
        List<String> maxs = new ArrayList<String>();
        for (int i = 0; i < in.length; i++) {
            char[] cs = in[i].toCharArray();
            Set<Character> str = new HashSet<Character>();
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == ' ') {
                    continue;
                }
                str.add(cs[j]);
            }
            if (str.size() == maxn) {
                maxs.add(in[i]);
            } else if (str.size() > maxn) {
                maxn = str.size();
                maxs.clear();
                maxs.add(in[i]);
            }
        }
        Collections.sort(maxs);
        return maxs.get(0);
    }
}
