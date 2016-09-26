package Alibaba;

import java.text.DecimalFormat;
import java.util.*;
/**
 * Created by yanglu on 16/9/19.
 */
public class Main2{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String sn=in.nextLine(), sm=in.nextLine();
            //long n=Long.parseLong(in.nextLine()), m=Long.parseLong(in.nextLine());
            char[] cn= sn.toCharArray();
            Arrays.sort(cn);
            if(cn[0]=='0' && cn.length>1){
                cn[0]=cn[1];
                cn[1]='0';
            }
            String s=new String(cn);
            System.out.println(s.equals(sm)?"YES":"NO");
        }
    }
}
