/**
 * Created by Administrator on 2016/5/23.
 */
class tree{
    int v,c=1;
    tree left,right;
    public tree(int v){
        this.v=v;
    }
}
public class s532_2 {
    public long reversePairs(int[] A) {
        if (A==null || A.length==0)
            return 0;
        long sum=0;
        tree root=new tree(A[A.length-1]);
        for(int i=A.length-2;i>=0;i--)
            sum += build(root,A[i]);
        return sum;
    }
    public long build(tree root,int v){
        long c=0;
        while(true) {
            if (v <=root.v) {
                root.c++;
                if (root.left == null) {
                    root.left = new tree(v);
                    break;
                }
                else
                    root=root.left;
            }
            else{
                c+=root.c;
                if (root.right == null) {
                    root.right = new tree(v);
                    break;
                }
                else
                    root=root.right;
            }
        }
        return c;
    }
}
