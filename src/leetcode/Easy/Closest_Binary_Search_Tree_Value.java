package leetcode.Easy;

import java.util.Map;
import java.util.Stack;

/**
 * Created by yanglu on 16/8/7.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Closest_Binary_Search_Tree_Value {

    public int closestValue(TreeNode root, double target) {
        //Solution 1:
        // double ans=root.val*1.0;

//        Stack<TreeNode> s=new Stack<>();
//        while(!s.isEmpty() || root!=null){
//            if(root!=null){
//                s.push(root);
//                root=root.left;
//            }
//            else{
//                TreeNode t=s.pop();
//                if(Math.abs(t.val-target) < Math.abs(ans-target))
//                    ans=t.val;
//                root=t.right;
//            }
//        }
//        return (int)ans;


        //Solution 2:
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;

    }
}
