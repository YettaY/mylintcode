package Alibaba;

import java.util.Scanner;
import java.util.*;
/**
 * Created by yanglu on 16/9/23.
 */

public class Main6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            String s=in.nextLine();
            StringBuilder sb=new StringBuilder();
            String[] str=s.split(" ");
            for(int i=str.length-1;i>=0;i--){
                if(!str[i].equals(""))
                    sb.append(str[i]+" ");
            }
            System.out.println(sb.length()==0 ? "":sb.substring(0,sb.length()-1));
        }

    }
}

