package google;

import Search.BFS;

/**
 * 判断两个binary tree 是不是similar：similar的要求是经过一定数目的交换左右子树，两个树是identical的
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SimilarTree {
    public Boolean isSimilar(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1!=null && root2==null)
            return false;
        if(root1==null && root2!=null)
            return false;
        if(root1.val!=root2.val)
            return false;
        Boolean ll = isSimilar(root1.left, root2.left);
        if(ll)
            return isSimilar(root1.right, root2.right);
        else {
            Boolean lr = isSimilar(root1.left, root2.right);
            if (!lr)
                return false;
            else
                return isSimilar(root1.right, root2.left);
        }
    }
}
