import java.util.*;
/**
 * Created by Administrator on 2016/6/3.
 */
public class Main {
    public static void main(String[] args){
//        Scanner in=new Scanner(System.in);
//        while(in.hasNext()){
//            int a=Integer.valueOf(in.nextLine());
//            String[] s=in.nextLine().split(" ");
//            int b=Integer.valueOf(s[0]), c=Integer.valueOf(s[1]);
//            String str=in.nextLine();
//            System.out.println((a+b+c)+" "+str);
//        }

        Scanner sc = new Scanner(System.in);
        // get a integer
        int a = sc.nextInt();
        // get two integers separated with half-width break
        int b = sc.nextInt();
        int c = sc.nextInt();
        // get a string
        String s = sc.next();
        // output
        System.out.println((a+b+c) + " " + s);
    }
}
