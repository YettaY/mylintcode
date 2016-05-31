import sun.nio.cs.ext.MacHebrew;

/**
 * Created by Administrator on 2016/5/23.
 */

public class s535 {
    public int houseRobber3(TreeNode root) {
        if(root==null)
            return 0;
        int[] r=dfs(root);
        return Math.max(r[0],r[1]);
    }
    public int[] dfs(TreeNode root){
        if (root==null)
            return new int[2];
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] r=new int[2];
        r[0]=left[1]+right[1]+root.val;
        r[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return r;
    }
}
