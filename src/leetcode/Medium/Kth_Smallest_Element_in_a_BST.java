package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/5.
 */
public class Kth_Smallest_Element_in_a_BST {
    //Solution 1: O(N)
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> s=new Stack<TreeNode>();
//        while(!s.isEmpty() || root!=null){
//            if(root!=null){
//                s.push(root);
//                root=root.left;
//            }
//            else{
//                TreeNode t=s.pop();
//                if((k--)==1)
//                    return t.val;
//                root=t.right;
//            }
//        }
//        return 0;
//    }

    //Solution 2: O(N)
//    public int kthSmallest(TreeNode root, int k) {
//        if(root==null)
//            return 0;
//        int[] r=new int[2];
//        in(root,r,k);
//        return r[1];
//    }
//    public void in(TreeNode root,int[] r, int k){
//        if(root==null)
//            return;
//        in(root.left,r, k);
//        if(r[0]<k){
//            r[0]++;
//            if(r[0]==k){
//                r[1]=root.val;
//                return;
//            }
//        }
//        in(root.right,r,k);
//    }

    //Solution 2: It has O(N * lg N) average runtime and O(N^2) for worst case;
//    public int kthSmallest(TreeNode root, int k) {
//        int c=count(root.left);
//        if(k<=c)
//            return kthSmallest(root.left, k);
//        if(k>c+1)
//            return kthSmallest(root.right, k-1-c);
//        return root.val;
//    }
//    public int count(TreeNode root){
//        if(root==null)
//            return 0;
//        return 1+count(root.left)+count(root.right);
//    }

    // Solution 3: Follow up
/*If we could add a count field in the BST node class, it will take O(n) time when we calculate the count value for the whole tree,
but after that, it will take O(logn) time when insert/delete a node or calculate the kth smallest element.
Once you rebuild the tree with new countnode, it takes O(lgn) to find the desired value.
You just need to update the relevant count value after insertion and deletion. it does not take extra time.*/
    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null) rootWithCount.count += rootWithCount.left.count;
        if (rootWithCount.right != null) rootWithCount.count += rootWithCount.right.count;
        return rootWithCount;
    }

    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count) return -1;
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k) return kthSmallest(rootWithCount.left, k);
            if (rootWithCount.left.count == k-1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k-1-rootWithCount.left.count);
        } else {
            if (k == 1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k-1);
        }
    }

    class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) {val = x; count = 1;};
    }
}
