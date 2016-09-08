package leetcode.Easy;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Symmetric_Tree {
    //Solution 1: recursion
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null)
//            return true;
//        return dfs(root.left, root.right);
//    }
//    public boolean dfs(TreeNode p, TreeNode q){
//        if(p==null && q==null)
//            return true;
//        if(p==null || q==null)
//            return false;
//        if(p.val==q.val)
//            return dfs(p.left, q.right) && dfs(p.right, q.left);
//        return false;
//    }

    // Solution 2: iterative
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (q.size()>1){
            TreeNode left=q.poll(), right=q.poll();
            if(left==null && right==null)
                continue;
            else if(left==null || right==null || left.val!=right.val)
                return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

}
