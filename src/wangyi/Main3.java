package wangyi;

/**
 * 异或求没上班的人start=1,end=3, 数据是1,2 则3没上班
 * 猪小怕做的~
 * Created by yanglu on 16/8/2.
 */
import java.util.*;

public class Main3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int d = n - m;
        long mm = (long)m;
        long nn = (long)n;
        long dd = (long)(d + 1);
        long sum = (mm + nn) * dd / 2;
        for(int i = 0; i < d; i++)
        {
            int num = in.nextInt();
            long nnn = (long)num;
            sum -= nnn;
        }

        System.out.println(sum);
    }

}
