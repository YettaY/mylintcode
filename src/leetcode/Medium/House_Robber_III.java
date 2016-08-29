package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/27.
 */
public class House_Robber_III {
    // Solution 1:
    Map<TreeNode, Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int v=0;
        if(root.left!=null)
            v += rob(root.left.left) + rob(root.left.right);
        if(root.right!=null)
            v += rob(root.right.left) + rob(root.right.right);
        v = Math.max( v+root.val, rob(root.left) + rob(root.right));
        map.put(root, v);
        return v;
    }
    // Solution 2:
//    public int rob(TreeNode root) {
//        if(root==null)
//            return 0;
//        int[] r=helper(root);
//        return Math.max(r[0], r[1]);
//    }
//    public int[] helper(TreeNode root){
//        if(root==null)
//            return new int[2];
//        int[] l=helper(root.left);
//        int[] r=helper(root.right);
//        int[] ans=new int[2];
//        ans[0]=root.val + l[1]+r[1];
//        ans[1]=Math.max(l[0],l[1]) + Math.max(r[0], r[1]);
//        return ans;
//    }
}
