import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2016/6/1.
 */
public class test {
    public static void main(String[] args) throws IOException {
       // FileReader f=new FileReader("C:\\Users\\Administrator\\Desktop\\tosogou_50w_result_uniq.txt");
     //   BufferedReader br=new BufferedReader(f);
        String s;
        int i=0;
        long tagid;
        Scanner in=new Scanner(System.in);
        tagid=in.nextLong();
       long tagclass =(tagid & 0xFFFF000000000000l) >> 48;
        long weight=tagid & 0x000000000000FFFFl;
        long tagcontent = tagid & 0xFFFFFFFFFFFF0000l;
        StringBuilder sb=new StringBuilder();
        sb.append(tagcontent+"," +tagclass+","+weight);
        System.out.println(sb.toString());


   //     System.out.println(tag+" "+tag.substring(0,2));
//        while((s=br.readLine())!=null){
//            String[] str=s.split("\t");
//            System.out.println(str[0]);
//
//            i++;
//            if (i==10)
//                break;
//        }
    }
}
