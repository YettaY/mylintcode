package wangyi;

/**
 * 输入一个字符串,输出匹配成ntes的个数,如 nntteess->16
 * Created by yanglu on 16/8/2.
 */
import java.util.*;
public class Main {
    static int r=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s=in.nextLine();
            if(s==null || s.length()<4){
                System.out.println(0);
                continue;
            }
            r=0;
            dfs(s,new StringBuilder(),0);
            System.out.println(r);
        }
    }
    public static void dfs(String s, StringBuilder sb, int id){
        if(sb.length()==4) {
            if(sb.toString().equals("ntes")) {
                //System.out.println(sb.toString());
                r++;

            }
            return;
        }

        for(int i=id;i<s.length();i++){

            sb.append(s.charAt(i));
            dfs(s,sb,i+1);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}
