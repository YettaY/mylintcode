package hiho;
import java.util.*;
/**
 * Created by Administrator on 2016/8/7.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();
        int max = cnt(a);
        if (max * 2 > a.length + 1) {
            System.out.print(-1);
            return ;
        }

        List<List<Integer>> r=new ArrayList();
        Arrays.sort(a);
        dfs(r, a, 0,0);
        if (r.size() == 0) {
            System.out.print(-1);
            return;
        }
        Collections.sort(r, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); ++i) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i).compareTo(o2.get(i));
                }
                return 0;
            }
        });
   //     System.out.println(r);
        List<Integer> result = r.get(0);
//        for (int i=0;i<r.size();i++){
//            List<Integer> cur=r.get(i);
//            boolean f=true;
//            for(int j=0;j<cur.size()-1;j++){
//                if (cur.get(j)==cur.get(j+1)){
//                    f=false;
//                    break;
//                }
//            }
//            if(f){
//               result=cur;
//                break;
//            }
//        }
        for (int i = 0; i < result.size(); ++i) {
            if (i == result.size() - 1)
                System.out.print(result.get(i));
            else
                System.out.print(result.get(i) + " ");
        }
    }
    public static void dfs(List<List<Integer>> r,int[] n,int id,int last){
        if(id==n.length){
            List<Integer> cur=new ArrayList();
            for(int i=0;i<n.length;i++)
                cur.add(n[i]);
            r.add(cur);
            return;
        }
        for(int i=id;i<n.length;i++){

            int t=n[i];
            n[i]=n[id];
            n[id]=t;
            if(i-1>=0 && n[i]==n[i-1] || i+1<n.length && n[i]==n[i+1]|| id-1>=0 && n[id-1]==n[id] || id+1<n.length && n[id]==n[id+1])
                continue;
            if(!isvalid(n, id, i))
                continue;
            dfs(r,n, id+1,n[i]);
            t=n[i];
            n[i]=n[id];
            n[id]=t;

        }
    }
    public static int cnt(int[] a) {
        Arrays.sort(a);
        int count = 1;
        int max = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] == a[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    public static boolean isvalid(int[] n,int s, int e){
        Set<Integer> set=new HashSet<>();
        for(int i=s;i<e;i++) {
            if (set.contains(n[i]))
                return false;
            set.add(n[i]);
        }
        return true;
    }
}
