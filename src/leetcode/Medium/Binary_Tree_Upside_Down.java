package leetcode.Medium;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Administrator on 2016/9/7.
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
        1
      / \
     2   3
   / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
       4
      / \
    5   2
       / \
      3   1

 看成梳子，1,2,4是数字把，3,5是梳子齿，转换以后变成：
        1
       /
      2---3
     /
    4----5
 */
public class Binary_Tree_Upside_Down {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //Solution 1:
//        if(root==null || root.left==null)
//            return root;
//        TreeNode ret = upsideDownBinaryTree(root.left);
//        root.left.left = root.right;
//        root.left.right=root;
//        root.left=null;
//        root.right=null;
//        return ret;

        //Solution 2:
        TreeNode cur=root, pre=null, right=null;
        while(cur!=null){
            TreeNode left=cur.left;
            cur.left=right;
            right=cur.right;
            cur.right=pre;
            pre=cur;
            cur=left;
        }
        return pre;
    }


}
