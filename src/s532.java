/**
 * Created by yanglu on 16/5/23.
 */
public class s532 {
    public long reversePairs(int[] A) {
        if (A==null || A.length==0)
            return 0;

        return mergesort(A, 0, A.length-1);
    }
    private long mergesort(int[] a, int s, int e) {
        if (s>=e)
            return 0;
        long sum=0;
        int m=(s+e)/2;
        sum+=mergesort(a,s,m);
        sum+=mergesort(a,m+1,e);
        sum+=merge(a,s,m,e);
        return sum;
    }

    private long merge(int[] a, int s, int m, int e) {
        int[] t=new int[a.length];
        int i=s,j=m+1;
        long sum=0; int k=s;
        while (i<=m && j<=e){
            if (a[i]<=a[j])
                t[k++]=a[i++];
            else{
                sum+=m-i+1;
                t[k++]=a[j++];
            }
        }
        while (i<=m)
            t[k++]=a[i++];
        while (j<=e)
            t[k++]=a[j++];
        for (i=s;i<=e;i++)
            a[i]=t[i];
        return sum;
    }

}
