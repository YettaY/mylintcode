package leetcode.Medium;


import java.util.*;

/**
 * Created by yanglu on 16/7/24.
 */
public class Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
        //Solution 1:
//        if(s==null || s.length()==0)
//            return s;
//        String[] str=s.split(" ");
//        StringBuilder sb=new StringBuilder("");
//        for(int i=str.length-1;i>=0;i--)
//            if(!str[i].equals(""))
//                sb.append(str[i]+" ");
//        return sb.length()==0? "" : sb.substring(0,sb.length()-1);

        //Solution 2:
        String r="";
        int p=0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) == ' ') {
                if(i>p)
                    r=s.substring(p, i)+" "+r;
                p=i+1;
            }
            else if (i==s.length()-1)
                    r=s.substring(p)+" "+r;
        }
        return r.length()==0 ? "" : r.substring(0, r.length()-1);
    }
    public static void main(String[] args){
        String s="";
        System.out.println("\""+reverseWords(s)+"\"");
    }
}
