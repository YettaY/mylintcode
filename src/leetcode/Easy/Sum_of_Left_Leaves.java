package leetcode.Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/9/27.
 */
public class Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
       if(root==null)
           return 0;
        int ans=0;
        // Solution 1:
//        if(root.left!=null){
//            if(root.left.left==null && root.left.right==null)
//                ans+=root.left.val;
//            else
//                ans+=sumOfLeftLeaves(root.left);
//        }
//        if(root.right!=null)
//            ans+=sumOfLeftLeaves(root.right);
//        return ans;

        //Solution 2:
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int layer=1;
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            layer--;
            if(t.left!=null) {
                if(t.left.left==null && t.left.right==null)
                    ans+=t.left.val;
                q.offer(t.left);
            }
            if(t.right!=null)
                q.offer(t.right);
            if(layer==0){
                layer=q.size();
            }
        }
        return ans;
    }

}
