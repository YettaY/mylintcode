package g_apac.Practice_Round_APAC_test_2017;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2016/6/26.
 */
public class Robot_Rock_Band {
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
    }

    private static void dfs(List<List<Integer>> r,List<Integer> cur,int[] c,int n,int k,int id ){
        if(cur.size()==4){
            //  if (id==c.length) {
            int t = 0;
            for (int i : cur) {
                t ^= i;
            }
            if (t == k)
                r.add(new ArrayList(cur));
            //    }
            return;
        }

        for(int i=id;i<c.length && i<id+n;i++){
            cur.add(c[i]);
            dfs(r, cur, c, n, k, i+n);
            cur.remove(cur.size()-1);
        }
    }
    private static void dfs1(Set<List<Integer>> r,List<Integer> cur,int[] a,int[] b,int[] c,int[] d, int n,int k,int ai, int bi,int ci,int di ){
        if(cur.size()==4){
            //  if (id==c.length) {
            int t = 0;
            for (int i : cur) {
                t ^= i;
            }
            if (t == k)
                r.add(new ArrayList(cur));
            //    }
            return;
        }
        int i,j,p,q;
        for(i=ai;i<a.length ;i++){
            cur.add(a[i]);
            for (j=bi;j<b.length;j++){
                cur.add(b[j]);
                for (p=ci;p<c.length;p++){
                    cur.add(c[p]);
                    for ( q=di; q<d.length;q++){
                        cur.add(d[q]);
                        dfs1(r, cur, a, b, c, d, n, k, i, j, p, q+1);
                        cur.remove(cur.size()-1);
                    }
                    dfs1(r, cur, a, b, c, d, n, k, i, j, p+1, di);
                    cur.remove(cur.size()-1);
                }
                dfs1(r, cur, a, b, c, d, n, k, i, j+1, ci, di);
                cur.remove(cur.size()-1);
            }
            dfs1(r, cur, a, b, c, d, n, k, i+1, bi, ci, di);
            cur.remove(cur.size()-1);
        }
    }
private static void dfs2(Set<List<Integer>> r,Map<Integer,Integer> cur,int[] a,int[] b,int[] c,int[] d, int k,int ai, int bi,int ci,int di ){
    if(cur.size()==4){
        //  if (id==c.length) {
        int t = 0;
      //  StringBuffer sb=new StringBuffer();
        List<Integer> list=new ArrayList<>();
        for (int i : cur.keySet()) {

            t ^= cur.get(i);
      //      sb.append(i+"->"+cur.get(i)+" ");
            list.add(cur.get(i));
        }
        if (t == k && !r.contains(list)) {
            r.add(list);
        }
        //    }
        return;
    }
    int i,j,p,q;
    for(i=ai;i<a.length ;i++){
        cur.put(1,a[i]);
        for (j=bi;j<b.length;j++){
            cur.put(2,b[j]);
            for (p=ci;p<c.length;p++){
                cur.put(3,c[p]);
                for ( q=di; q<d.length;q++){
                    cur.put(4,d[q]);
                    dfs2(r, cur, a, b, c, d, k, i, j, p, q+1);
                    cur.remove(cur.size()-1);
                }
                dfs2(r, cur, a, b, c, d, k, i, j, p+1, di);
                cur.remove(cur.size()-1);
            }
            dfs2(r, cur, a, b, c, d, k, i, j+1, ci, di);
            cur.remove(cur.size()-1);
        }
        dfs2(r, cur, a, b, c, d, k, i+1, bi, ci, di);
        cur.remove(cur.size()-1);
    }
}
    private static void dfs3(Set<String> r,Map<Pair,Integer> cur,int[] a,int[] b,int[] c,int[] d, int k,int ai, int bi,int ci,int di ){
        if(cur.size()==4){
            int t = 0;
            List<String> list=new ArrayList<>();
            String[] s=new String[5];
            StringBuilder sb=new StringBuilder();
            for (Pair i : cur.keySet()) {
                t ^= cur.get(i);
                s[(int)i.first]=i.second+"-"+cur.get(i);
             //   System.out.print(i.first+"/"+i.second+"-"+cur.get(i)+"  ");
            }
           // System.out.println();
            for (int id=1;id<=4;id++) {
                if (s[id]==null || s.length==0)
                    return;
                sb.append(id+"/"+s[id]+" ");

            }
            if (sb.toString().equals("1/1-10 2/0-1 3/1-10 4/0-1"))
                System.out.println("find!!");
            if (t == k ) {
                if (!r.contains(sb.toString()))
                    r.add(sb.toString());
            }
            return;
        }
        int i,j,p,q;
        for(i=ai;i<a.length ;i++){
            Pair na=new Pair(1,i);
            cur.put(new Pair(1,i),a[i]);
            for (j=bi;j<b.length;j++){
                Pair nb=new Pair(2,j);
                cur.put(new Pair(2,j),b[j]);
                for (p=ci;p<c.length;p++){
                    Pair nc=new Pair(3,p);
                    cur.put(new Pair(3,p),c[p]);
                    for ( q=di; q<d.length;q++){
                        Pair nd=new Pair(4,q);
                        cur.put(new Pair(4,q),d[q]);
                        dfs3(r, cur, a, b, c, d, k, i, j, p, q+1);
                        cur.remove(nd);
                    }
                    dfs3(r, cur, a, b, c, d, k, i, j, p+1, di);
                    cur.remove(nc);
                }
                dfs3(r, cur, a, b, c, d, k, i, j+1, ci, di);
                cur.remove(nb);
            }
            dfs3(r, cur, a, b, c, d, k, i+1, bi, ci, di);
            cur.remove(na);
        }
    }
    public static void main(String[] args)throws IOException {
        Scanner in = new Scanner(new File("in.txt"));//B-small-practice.in
        FileWriter fw = new FileWriter("out1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        int tcase = in.nextInt();

        for (int id = 1; id <= tcase; id++) {
            bw.write("Case #" + id + ": ");

            int n=in.nextInt(), k=in.nextInt();
            int[] list=new int[4*n];
            int[] a=new int[n], b=new int[n], c=new int[n], d=new int[n];
//            for (int i=0;i<list.length;i++) {
//                list[i] = in.nextInt();
//
//            }
            Map<Integer,Integer> ma=new HashMap<>(), mb=new HashMap<>(),mc=new HashMap<>(),md=new HashMap<>();
            for(int i=0;i<n;i++) {
                a[i] = in.nextInt();
                if (!ma.containsKey(a[i]))
                    ma.put(a[i],1);
                else
                    ma.put(a[i],ma.get(a[i])+1);
            }
            for(int i=0;i<n;i++) {
                b[i] = in.nextInt();
                if (!mb.containsKey(b[i]))
                    mb.put(b[i],1);
                else
                    mb.put(b[i],mb.get(b[i])+1);
            }
            for(int i=0;i<n;i++) {
                c[i] = in.nextInt();
                if (!mc.containsKey(c[i]))
                    mc.put(c[i],1);
                else
                    mc.put(c[i],mc.get(c[i])+1);
            }
            for(int i=0;i<n;i++) {
                d[i] = in.nextInt();
                if (!md.containsKey(d[i]))
                    md.put(d[i],1);
                else
                    md.put(d[i],md.get(d[i])+1);
            }
            Set<String> r=new HashSet<>();
            Set<List<Integer>> r2=new HashSet<>();
           // dfs(r, new ArrayList<Integer>(),list,n,k,0);
           // dfs1(r, new ArrayList<Integer>(), a,b,c,d,n,k,0,0,0,0);
            dfs2( r2,new HashMap<Integer, Integer>(),a,b,c,d,k,0,0,0,0);
           // dfs3( r,new HashMap<Pair, Integer>(),a,b,c,d,k,0,0,0,0);
         //   System.out.println(r2);
            int sum=0;
            for (List<Integer> tmp: r2){
                sum += (ma.get(tmp.get(0))*mb.get(tmp.get(1))*mc.get(tmp.get(2))*md.get(tmp.get(3)));
            }
            bw.write(sum+"\n");

        }
        bw.close();
        fw.close();
    }
}
