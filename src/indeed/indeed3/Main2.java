package indeed.indeed3;

import java.util.*;

public class Main2 {
    static class node{
        String n;
        int index;
        long time;
        public node(String name,int id,long time){
            this.n=name;
            this.index=id;
            this.time=time;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A=in.nextInt(), B=in.nextInt(), K=in.nextInt();
        node[] ns=new node[2*K];
        for (int i=0;i<K;i++)
            ns[i]=new node("Takahashi",i,(long) ((i+1)*A*1.0));

        for (int i=K;i<2*K;i++)
            ns[i]=new node("Aoki",i,(long) ((i-K+1)*B*1.0+0.5));
        Arrays.sort(ns, new Comparator<node>() {
            public int compare(node o1, node o2) {
                return (int)(o1.time*10-o2.time*10);
            }
        });
        System.out.println(ns[K-1].n);
    }
}