package leetcode.Hard;

import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Note:
 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 Follow up:
 Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class Closest_Binary_Search_Tree_Value_II {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //Solution 1 : O(n)
//        Set<Integer> set=new HashSet<>();
//        List<Integer> r=new ArrayList<>();
//        Deque<Integer> q=new LinkedList<>();
//        Stack<TreeNode> s=new Stack<>();
//        while(!s.isEmpty() || root!=null){
//            if(root!=null){
//                s.push(root);
//                root=root.left;
//            }
//            else{
//                TreeNode t=s.pop();
//                if(q.size()==k && Math.abs(q.peekFirst()*1.0 - target) > Math.abs(t.val*1.0 - target))
//                    q.pollFirst();
//                q.offer(t.val);
//                if(q.size()==k)
//                    r=new ArrayList<>(q);
//                root=t.right;
//            }
//        }
//        return r;

        //Solution 2: O(Nlogn)
        Deque<TreeNode> bigger = new ArrayDeque<TreeNode>();
        Deque<TreeNode> smaller = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        // log(n)
        while(node != null)
        {
            if(node.val > target)
            {
                bigger.push(node);
                node = node.left;
            }
            else
            {
                smaller.push(node);
                node = node.right;
            }
        }

        // k
        List<Integer> ret = new ArrayList<Integer>();
        while(ret.size() < k)
        {
            if(bigger.isEmpty() ||
                    !smaller.isEmpty() &&
                            ((bigger.peek().val - target) > (target - smaller.peek().val)))
            {
                node = smaller.pop();
                ret.add(node.val);

                // Get next smaller
                node = node.left;
                while(node != null)
                {
                    smaller.push(node);
                    node = node.right;
                }
            }
            else
            {
                node = bigger.pop();
                ret.add(node.val);

                // get next bigger
                node = node.right;
                while(node != null)
                {
                    bigger.push(node);
                    node = node.left;
                }
            }
        }

        return ret;
    }
}
