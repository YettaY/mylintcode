package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/11.
 *
 PROBLEM:

 Choose k entries from n numbers. Make sure each number is selected with the probability of k/n
 BASIC IDEA:

 Choose 1, 2, 3, ..., k first and put them into the reservoir.
 For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
 For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
 Repeat until k+i reaches n
 PROOF:

 For k+i, the probability that it is selected and will replace a number in the reservoir is k/(k+i)
 For a number in the reservoir before (let's say X), the probability that it keeps staying in the reservoir is
 P(X was in the reservoir last time) * (P(k+i is not chosen) + P(k+i is chosen but X is not replaced))
 = k/(k+i-1) * (i/(k+i) + k/(k+i) * (k-1)/k) = k/(k+i).
 When k+i reaches n, the probability of each number staying in the reservoir is k/n

 nextInt()没有参数的情况是-2^31到2^31-1
 */
public class Linked_List_Random_Node {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //Solution1: 这道题给了我们一个链表，让我们随机返回一个节点，那么最直接的方法就是先统计出链表的长度，然后根据长度随机生成一个位置，然后从开头遍历到这个位置即可
//    public class Solution {
//        ListNode head;
//        int len;
//        /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
//        public Solution(ListNode head) {
//            this.head=head;
//            ListNode cur=head;
//            len=0;
//            while(cur!=null){
//                cur=cur.next;
//                len++;
//            }
//        }
//
//        /** Returns a random node's value. */
//        public int getRandom() {
//            ListNode cur=head;
//            Random rand=new Random();
//            int t=rand.nextInt(len);
//            while(t>0){
//                --t;
//                cur=cur.next;
//            }
//            return cur.val;
//        }
//    }


    //Solution2:
    /*Follow up中说链表可能很长，我们没法提前知道长度，这里用到了著名了水塘抽样的思路，
    由于限定了head一定存在，所以我们先让返回值res等于head的节点值，然后让cur指向head的下一个节点，
    定义一个变量i，初始化为2，若cur不为空我们开始循环，我们在[0, i - 1]中取一个随机数，如果取出来0，那么我们更新res为当前的cur的节点值，然后此时i自增一，cur指向其下一个位置，这里其实相当于我们维护了一个大小为1的水塘，然后我们随机数生成为0的话，我们交换水塘中的值和当前遍历到底值，这样可以保证每个数字的概率相等*/

    public class Solution {

        ListNode head;
        /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head=head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random rand=new Random();
            int r=head.val;
            ListNode cur=head.next;
            int i=1;
            while(cur!=null) {
                if (rand.nextInt(i) == 0)
                    r = cur.val;
                i++;
                cur = cur.next;
            }
            return r;
        }
    }




}
