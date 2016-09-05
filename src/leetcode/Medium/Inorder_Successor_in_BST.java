package leetcode.Medium;
import sun.plugin2.message.BestJREAvailableMessage;

import java.util.*;
/**
 * Created by Administrator on 2016/9/1.
 */
public class Inorder_Successor_in_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Solution 1: 后继
//        if(root==null)
//            return null;
//        if(root.val<=p.val)
//            return inorderSuccessor(root.right, p);
//        else{
//            TreeNode left=inorderSuccessor(root.left, p);
//            return left!=null ? left : root;
//        }

        //前驱
//        if(root==null)
//            return null;
//        if(root.val>=p.val)
//            return inorderSuccessor(root.left, p);
//        else{
//            TreeNode right=inorderSuccessor(root.right, p);
//            return right!=null ? right : root;
//        }

        //Solution 2：后继
        TreeNode succ=null;
        while(root!=null){
            if (root.val<=p.val)
                root=root.right;
            else{
                succ=root;
                root=root.left;
            }
        }

        return succ;
    }
    public static void main(String[] args){
        Integer i1=-127, i2=-127, i3=128, i4=128;
        System.out.println(i1==i2);
        System.out.println(i1.equals(i2));
        System.out.println(i3==i4);
        System.out.println(i3.equals(i4));
    }
}
