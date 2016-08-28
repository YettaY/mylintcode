package leetcode.Medium;

/**
 * Created by yanglu on 16/8/27.
 * 1.时间复杂度为O(nlogn)，这种方法是把每个节点都当做根节点，来验证其是否是二叉搜索树，并记录节点的个数，
 * 若是二叉搜索树，就更新最终结果
 * 2.
 */
public class Largest_BST_Subtree {
    int ans=0;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return ;
        int d=countBFS(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(d!=-1){
            ans=Math.max(ans,d);
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public int countBFS(TreeNode root, int min, int max){
        if(root==null)
            return 0;
        if(root.val <=min || root.val >= max)
            return -1;
        int left=countBFS(root.left, min, root.val);
        if(left==-1)
            return -1;
        int right=countBFS(root.right, root.val, max);
        if(right==-1)
            return -1;
        return left+right+1;
    }
}
