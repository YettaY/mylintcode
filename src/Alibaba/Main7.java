package Alibaba;

/**
 * Created by yanglu on 16/9/23.
 */
import java.util.*;

public class Main7
{
    static void recount(int n,char c, int[] count,int[] a, String[] s)
    {
        if(a[c-'A'] > 0) {
            count[n] = a[c-'A'];
            for (int i = 0; i < s[n].length(); i++) {
                a[s[n].charAt(i) - 'A']--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String[] alphabeta = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
        String[] trans = {"2","3","4","5","6","7","8","9","0","1"};
        for(int i = 0; i < T; i++)
        {
            String line = in.nextLine();
            int[] alpha = new int[26];
            int[] count = new int[10];
            for(int j = 0; j < line.length(); j++ )
            {
                alpha[line.charAt(j) - 'A'] ++;
            }
            recount(0,'Z',count,alpha,alphabeta);

            recount(2,'W',count,alpha,alphabeta);

            recount(4,'U',count,alpha,alphabeta);

            recount(6,'X',count,alpha,alphabeta);

            recount(8,'G',count,alpha,alphabeta);

            recount(3,'T',count,alpha,alphabeta);

            recount(5,'F',count,alpha,alphabeta);

            recount(7,'S',count,alpha,alphabeta);

            recount(1,'O',count,alpha,alphabeta);

            recount(9,'I',count,alpha,alphabeta);

            for(int j = 0; j < 10; j++)
            {
                if(count[(j+8) % 10] > 0)
                    for(int k = 0; k < count[(j+8) % 10]; k++)
                        System.out.print(trans[(j+8)%10]);
            }
            System.out.println();
        }
    }

}
