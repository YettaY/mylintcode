package leetcode.Medium;
import java.util.*;
/**
 * Created by yanglu on 16/9/7.
 */
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        //Solution 1:
//        List<Integer> r=new ArrayList<Integer>();
//        if(root==null)
//            return r;
//        Queue<TreeNode> q=new LinkedList<TreeNode>();
//        int layer=1;
//        q.offer(root);
//        while(!q.isEmpty()){
//            TreeNode t=q.poll();
//            if(layer==1)
//                r.add(t.val);
//            layer--;
//            if(t.left!=null)
//                q.offer(t.left);
//            if(t.right!=null)
//                q.offer(t.right);
//            if(layer==0)
//                layer=q.size();
//        }
//        return r;

        //Solution 2:每一个depth只取一个元素
        List<Integer> r=new ArrayList<>();
        if(root==null)
            return r;
        dfs(root, r, 0);
        return r;
    }
    public void dfs (TreeNode root, List<Integer> r, int depth){
        if(root==null)
            return;
        if(depth==r.size())
            r.add(depth,root.val);
        dfs(root.left, r, depth+1);
        dfs(root.right,r,depth+1);
    }
}
