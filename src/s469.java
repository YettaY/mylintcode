/**
 * Created by Administrator on 2016/5/16.
 */
public class s469 {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        return dfs(a,b);
    }
    public boolean dfs(TreeNode a, TreeNode b){
        if (a==null && b==null)
            return true;
        if (a!=null && b!=null)
            if (a.val!=b.val)
                return false;
        if (a==null || b==null)
            return false;
        return dfs(a.left,b.left) && dfs(a.right,b.right);
    }
}
