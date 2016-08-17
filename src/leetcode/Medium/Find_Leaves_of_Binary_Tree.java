package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/11.

 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:

 1
 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].

 Idea is depth first search, pass the result list(List<List<Integer>>) as parameter into the dfs function, do the following modification on the list:

 When traversing down the tree, add an empty list(List<Integer>) into the result set when the size of the result set is less than the current height of the tree.
 When backtracking, calculate the height of current node, then add it to the corresponding list(List<Integer>) we created in step 1.
 N: number of nodes
 H: height of the tree
 Time: O(N), Space: O(N)
 */
public class Find_Leaves_of_Binary_Tree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, root, 1);
        return list;
    }

    private int dfs(List<List<Integer>> traversal, TreeNode root, int level) {
        if (root == null)
            return -1;

        if (traversal.size() < level)
            traversal.add(new ArrayList<>());

        int l = dfs(traversal, root.left, level + 1);
        int r = dfs(traversal, root.right, level + 1);
        int index = Math.max(l, r) + 1;

        traversal.get(index).add(root.val);
        return index;
    }
}
