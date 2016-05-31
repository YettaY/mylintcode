/**
 * Created by Administrator on 2016/5/16.
 */
import java.util.*;
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class s480 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> r=new ArrayList<>();
        if (root==null)
            return r;
        dfs(r,"",root);
        return r;
    }
    public void dfs(List<String> r, String s, TreeNode root){
        if (root==null)
            return;
        s+=root.val;
        if (root.left==null && root.right==null){
            r.add(s);
            return;
        }
        dfs(r,s+"->",root.left);
        dfs(r,s+"->",root.right);
    }
}
