package Math;

/**
 * Created by yanglu on 16/10/3.
 * 二叉查找树的查找、插入、删除
 */
import java.util.*;
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        this.val=val;
    }
}
public class BSTop {
    public static boolean search(TreeNode root, int v){
        if(root==null)
            return false;
        while(root!=null){
            if(root.val==v)
                return true;
            if(root.val<v)
                root=root.right;
            else
                root=root.left;
        }
        return false;
    }
    public static TreeNode insert(TreeNode root, int v){
        if(root==null)
            return new TreeNode(v);
        if(v>root.val)
            root.right= insert(root.right, v);
        else if(v<root.val)
            root.left=insert(root.left, v);
        return root;
    }
    public static TreeNode deleteNode(TreeNode root, int v){
        //三种情况：删除的是叶子节点，删除的节点有左子树或右子树，删除的节点既有左子树又有右子树(找到该节点右子树中最小的节点值，与它替换，并删除该最小节点)
        if(root==null)
            return null;
        if(root.val<v)
            root.right=deleteNode(root.right, v);
        else if(root.val>v)
            root.left=deleteNode(root.left, v);
        else if(root.left!=null && root.right!=null){

            TreeNode cur=root.right, t=cur.left;
            while(t!=null){
                cur=t;
                t=t.left;
            }
            root.val=cur.val;

            root.right=deleteNode(root.right, cur.val);

        }
        else
            root=root.left!=null ? root.left : root.right;
        return root;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(7);
        TreeNode r3=new TreeNode(3);
        TreeNode r10=new TreeNode(10);
        root.left=r3; root.right=r10;

        TreeNode r1=new TreeNode(1);
        TreeNode r6=new TreeNode(6);
        TreeNode r5=new TreeNode(5);

        r3.left=r1; r3.right=r6; r6.left=r5;

        TreeNode r15=new TreeNode(15);
        TreeNode r18=new TreeNode(18);
        r10.right=r15; r15.right=r18;
        List<Integer> r=new ArrayList<Integer>();


       // System.out.println(search(root, 1));

       // root=insert(root, 13);
       root=deleteNode(root, 7);
        in(r, root);
        System.out.println(r);
    }

    public static void in(List<Integer> r, TreeNode root){
        if(root==null)
            return;
        in(r, root.left);
        r.add(root.val);
        in(r, root.right);

    }

}
