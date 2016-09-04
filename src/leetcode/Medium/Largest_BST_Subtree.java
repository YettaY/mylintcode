package leetcode.Medium;

/**
 * Created by yanglu on 16/8/27.
 * 1.时间复杂度为O(nlogn)，这种方法是把每个节点都当做根节点，来验证其是否是二叉搜索树，并记录节点的个数，
 * 若是二叉搜索树，就更新最终结果
 * 2.O(n)时间复杂度，采用DFS的思想来解题，由于时间复杂度的限制，只允许我们遍历一次整个二叉树，由于满足题目要求的 二叉搜索子树必定是有叶节点的，所以我们的思路就是先递归到最左子节点，然后逐层往上递归，对于每一个节点，我们都记录当前最大的BST的节点数，当做为左子树的最大值，和做为右子树的最小值，当每次遇到左子节点不存在或者当前节点值大于左子树的最大值，且右子树不存在或者当前节点值小于右子树的最小数时，说明BST的节点数又增加了一个，我们更新结果及其参数，
 * 如果当前节点不是BST的节点，那么我们更新BST的节点数res为左右子节点的各自的BST的节点数的较大值
 */
public class Largest_BST_Subtree {
    //Soltuion 1:
//    int ans=0;
//    public int largestBSTSubtree(TreeNode root) {
//        dfs(root);
//        return ans;
//    }
//    public void dfs(TreeNode root){
//        if(root==null)
//            return ;
//        int d=countBFS(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
//        if(d!=-1){
//            ans=Math.max(ans,d);
//            return;
//        }
//        dfs(root.left);
//        dfs(root.right);
//    }
//
//    public int countBFS(TreeNode root, int min, int max){
//        if(root==null)
//            return 0;
//        if(root.val <=min || root.val >= max)
//            return -1;
//        int left=countBFS(root.left, min, root.val);
//        if(left==-1)
//            return -1;
//        int right=countBFS(root.right, root.val, max);
//        if(right==-1)
//            return -1;
//        return left+right+1;
//    }

    // Solution 2: bottom-up appoach
    int ans=0;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode root){
        int[] r=new int[3];  // # of nodes in the subtree, leftmost value, rightmost value; # of nodes in the subtree will be -1 if it is not a BST
        if (root==null)
            return r;
        int[] left=dfs(root.left), right=dfs(root.right);
        if((left[0] ==0 || left[0] > 0 && left[2] < root.val ) && (right[0] ==0 || right[0]>0 && root.val < right[1])){
            int min=Math.min(root.val, left[1]);
            int max=Math.max(root.val, right[2]);
            int size = left[0] + right[0] + 1;
            ans=Math.max(ans, size);
            r[0]=size;
            r[1]= left[0]==0? root.val : left[1];
            r[2]=right[0]==0?root.val : right[1];
        }
        else
            r[0]=-1;
        return r;
    }
}
