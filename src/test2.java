import java.io.*;

/**
 * Created by Administrator on 2016/6/20.
 */
public class test2 {
    public static void main(String[] args) throws IOException{
        FileReader fr=new FileReader("app");
        BufferedReader br=new BufferedReader(fr);

        FileReader fr1=new FileReader("tag");
        BufferedReader br1=new BufferedReader(fr1);

        FileWriter fw=new FileWriter("sogoutag.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        String s1="",s2="";

        while((s1= br.readLine())!=null){
            String[] user=s1.split("\t");
            String id=user[0];
            s2=br1.readLine();
            bw.write(id+"\t"+s2+"\n");

        }

        br.close();
        fr.close();
        br1.close();
        fr1.close();
        bw.close();
        fw.close();

    }

}
