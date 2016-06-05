/**
 * Created by Administrator on 2016/6/5.
 */
import java.util.*;

public class s178 {
    class uninfind{
        Map<Integer,Integer> father=new HashMap<>();
        uninfind(int n){
            for (int i=0;i<n;i++)
                father.put(i,i);
        }
        int compressed_find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent))
                parent = father.get(parent);
            int t = -1;
            int fa = father.get(x);
            while (fa != father.get(fa)) {
                t = father.get(fa);
                father.put(fa, parent);
                fa = t;
            }
            return parent;
        }
            void unin(int x,int y){
                int fa_x=compressed_find(x);
                int fa_y=compressed_find(y);
                if (fa_x!=fa_y)
                    father.put(fa_x,fa_y);
            }

    }
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n-1!=edges.length)
            return false;
        uninfind uf=new uninfind(n);
        for (int i=0;i<edges.length;i++){
            if (uf.compressed_find(edges[i][0])==uf.compressed_find(edges[i][1]))
                return false;
            uf.unin(edges[i][0],edges[i][1]);
        }
        return true;
    }
}
