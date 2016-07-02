package g_apac.Round_A_APAC_Test_2016;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by yanglu on 16/7/2.
 */
public class gsnake {
    static private class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair<?, ?> p = (Pair<?, ?>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
        }

        public static <A, B> Pair <A, B> create(A a, B b) {
            return new Pair<A, B>(a, b);
        }
    }

    static int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {

        Scanner in=new Scanner(new File("D-large-practice.in"));
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int tcase=in.nextInt();
        for (int id=1;id<=tcase;id++){
            bw.write("Case #"+id+": ");
            int lpos=1,rpos=1;
            int ndir = 0;
            int length = 1;

            int x=in.nextInt(), r=in.nextInt(), c=in.nextInt();

            Map<Integer,Character> m=new HashMap<>();
            Map<Pair,Integer> last=new HashMap<>();


            for (int i=1;i<=x;i++){
                int sec = in.nextInt();
                char dir = in.next().charAt(0);
                m.put(sec, dir);
            }
            last.put(new Pair(1,1),0);
            for(int j=1;j<=2000000;j++)
            {
                lpos+=direct[ndir][0];
                if(lpos==0)lpos=r;
                if(lpos==r+1)lpos=1;
                rpos+=direct[ndir][1];
                if(rpos==0)rpos=c;
                if(rpos==c+1)rpos=1;
                if(last.containsKey(new Pair(lpos,rpos)))
                {
                    if(last.get(new Pair(lpos,rpos))+length>j)break;
                }
                else
                {
                    if((lpos+rpos)%2==1)
                        length++;
                }
                last.put(new Pair(lpos,rpos),j);
                if(m.containsKey(j))
                {
                    if(m.get(j)=='R')ndir++;
                    else ndir--;
                    ndir &= 3;
                }

            }
            bw.write(length+"\n");
        }
        bw.close();
        fw.close();
    }
}
