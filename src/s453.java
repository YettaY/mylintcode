/**
 * Created by Administrator on 2016/5/16.
 */

public class s453 {
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        while(root!=null){
            TreeNode t=root;
            if (root.left!=null){
                t=t.left;
                while(t.right!=null){
                    t=t.right;
                }
            }

        }
    }
}
