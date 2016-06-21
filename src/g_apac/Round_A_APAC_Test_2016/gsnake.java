package g_apac.Round_A_APAC_Test_2016;

import java.io.*;
import java.util.*;
/**
 * Created by Administrator on 2016/6/20.
 */

public class gsnake {

    public static final class Pair< A,B> implements Serializable {
        private A first;
        private B second;

        public Pair(A first, B second) {
            super();
            this.first = first;
            this.second = second;
        }

    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
                    ((  this.first == otherPair.first ||
                            ( this.first != null && otherPair.first != null &&
                                    this.first.equals(otherPair.first))) &&
                            (	this.second == otherPair.second ||
                                    ( this.second != null && otherPair.second != null &&
                                            this.second.equals(otherPair.second))) );
        }

        return false;
    }

    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}
    static int[][] direct={{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(new File("D-large-practice.in"));//D-small-practice.in
        FileWriter fw=new FileWriter("out.txt");
        BufferedWriter bw=new BufferedWriter(fw);

        int t=in.nextInt();
        for (int i=1;i<=t;i++){
            bw.write("Case #"+i+": ");
            int lpos=1,rpos=1;
            int ndir = 0;
            int length = 1;

            int x=in.nextInt();
            int r=in.nextInt();
            int c=in.nextInt();

            Map<Integer,Character> m=new HashMap<>();
            Map<Pair<Integer,Integer>,Integer> last=new HashMap<>();
            for(int j=1;j<=x;j++)
            {
                int sec=in.nextInt();
                char[] dir=in.next().toCharArray();
                m.put(sec, dir[0]);
            }
            last.put(new Pair<>(1,1),0);
            for(int j=1;j<=2000000;j++)
            {
                lpos += direct[ndir][0];
                if(lpos==0)
                    lpos=r;
                if(lpos==r+1)
                    lpos=1;
                rpos += direct[ndir][1];
                if(rpos==0)
                    rpos=c;
                if(rpos==c+1)
                    rpos=1;
                Pair p=new Pair(lpos,rpos);
                if(last.containsKey(p))
                {
                    if(last.get(p)+length>j)
                        break;
                }
                else
                {
                    if((lpos+rpos)%2==1)
                        length++;
                }
                last.put(p, j);
                if(m.containsKey(j))
                {
                    if(m.get(j)=='R')
                        ndir++;
                    else
                        ndir--;
                    ndir &= 3;
                }
            }
            bw.write(length+"\n");
        }
        bw.close();
        fw.close();

    }

}
