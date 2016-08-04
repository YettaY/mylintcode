package google;
import java.util.*;
/**
 * 给一个array比如[4,2,1,3,5],根据这个array现在我们能有了一个新的array => 每个数是在原array里,
 * 在它左边的所有比它大的number的个数,就是[0,1,2,1,0]. 题目是现在给了这个[0,1,2,1,0]要求原array,
 * 原来array的range是1~n
 */
public class Array {
    public static int[] reorder(int[] a){
        if(a==null||a.length==0) return new int[0];
        int n = a.length;
        int[] b = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);//1,2,3,4,5
        }
        for(int i=n-1; i>=0; i--){
                b[i] = list.remove(i-a[i]);
        }

        return b;
    }
    public static void main(String[] args){
        int[] a={0,1,2,1,0};
        int[] b=reorder(a);
        for (int i:b)
            System.out.print(i+" ");
    }
}
