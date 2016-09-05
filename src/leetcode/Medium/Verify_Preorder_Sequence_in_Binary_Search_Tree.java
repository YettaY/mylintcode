package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/4.
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

 You may assume each number in the sequence is unique.

 Follow up:
 Could you do it using only constant space complexity?

 1.Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree.
 If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes, so just push the new one onto the stack.
 But before that, pop all smaller ancestor values, as we must now be in their right subtrees (or even further, in the right subtree of an ancestor).
 Also, use the popped values as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.

 2.Same as above, but abusing the given array for the stack.
 */
public class Verify_Preorder_Sequence_in_Binary_Search_Tree {
    public boolean verifyPreorder(int[] preorder) {
        //Solution 1:
//        int low=Integer.MIN_VALUE;
//        Stack<Integer> s=new Stack<>();
//        for(int p:preorder){
//            if(p<low)
//                return false;
//            while(!s.isEmpty() && s.peek() <p)
//                low=s.pop();
//            s.push(p);
//        }
//        return true;

        //Solution 2:
        int low=Integer.MIN_VALUE, i=-1;
        for(int p:preorder){
            if(p<low)
                return false;
            while(i>=0 && preorder[i] < p)
                low=preorder[i--];
            preorder[++i]=p;
        }
        return true;
    }
}
