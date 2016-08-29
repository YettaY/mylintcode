package youdao;

import java.util.*;

/**
 * Created by yanglu on 16/8/17.
 */
public class Main3 {
    static class node{
        int x1, y1,x2,y2;
        public node(int x1,int y1, int x2, int y2){
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
        }
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        node[] ns=new node[n];

        for(int id=0;id<n;id++){
            int x1=in.nextInt(), y1=in.nextInt(), x2=in.nextInt(), y2=in.nextInt();
            ns[id]=new node(x1,y1,x2,y2);
            String s="a"+"b";
        }
    }
}
