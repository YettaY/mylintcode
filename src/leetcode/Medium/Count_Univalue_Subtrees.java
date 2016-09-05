package leetcode.Medium;

/**
 * Created by yanglu on 16/9/4.
 * 求元素都相同的子树个数
 * Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,
     5
    / \
   1   5
  / \   \
 5   5   5
 return 4.
 */
public class Count_Univalue_Subtrees {
    int count=0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null)
            return 0;
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root){
        if(root==null)
            return true;
        boolean left=helper(root.left);
        boolean right=helper(root.right);
        if( left && right && (root.left==null || root.val==root.left.val ) && (root.right==null || root.val==root.right.val )){
            count++;
            return true;
        }
        return false;
    }

}
