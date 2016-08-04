package leetcode.Medium;

/**
 * Binary Tree Longest Consecutive Sequence
 Total Accepted: 437 Total Submissions: 1351 Difficulty: Medium
 Given a binary tree, find the length of the longest consecutive sequence path.
 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 For example,
 1
 \
  3
 / \
 2   4
      \
       5
 Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Binary_Tree_Longest_Consecutive_Sequence {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return max;
        }
        findLongestConsecutive(root, 0, root.val);
        return max;
    }

    private void findLongestConsecutive(TreeNode root, int curMax, int target) {
        if(root == null) {
            return;
        }
        if(root.val == target) {
            curMax++;
        } else {
            curMax = 1;
        }
        max = Math.max(max, curMax);
        findLongestConsecutive(root.left, curMax, root.val + 1);
        findLongestConsecutive(root.right, curMax, root.val + 1);
    }
}
