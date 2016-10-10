package leetcode.Easy;
import java.util.*;
/**
 * Created by Administrator on 2016/10/9.
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;

        //Solution 1:递归
//        TreeNode left=invertTree(root.left);
//        TreeNode right=invertTree(root.right);
//        root.left=right;
//        root.right=left;
//        return root;

        //Solution 2: 非递归
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null || cur.right!=null){
                TreeNode t=cur.left;
                cur.left=cur.right;
                cur.right=t;
            }
            if(cur.left!=null)
                q.offer(cur.left);
            if(cur.right!=null)
                q.offer(cur.right);
        }
        return root;
    }
}
