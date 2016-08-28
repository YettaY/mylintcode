package leetcode.Medium;

/**
 * Created by yanglu on 16/8/8.
 */
public class Plus_One_Linked_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode plusOne(ListNode head) {
        //Solution 1:
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode i = dummy;
//        ListNode j = dummy;
//
//        while (j.next != null) {
//            j = j.next;
//            if (j.val != 9) {
//                i = j;
//            }
//        }
//
//        i.val++;
//        i = i.next;
//        while (i != null) {
//            i.val = 0;
//            i = i.next;
//        }
//
//        if (dummy.val == 0) return dummy.next;
//        return dummy;

        //Solution 2:
        if(head==null)
            return new ListNode(1);
        ListNode p=plusOne(head.next);
        if(p!=head.next)
            head.val++;
        if(head.val<=9)
            return head;
        head.val=0;
        p.next=head;
        return p;
    }
    public static void main(String[] args){
        ListNode l=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(9);
        ListNode l4=new ListNode(9);
        ListNode l5=new ListNode(9);
        l.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
        ListNode t=plusOne(l);
        while(t!=null){
            System.out.print(t.val+" ");
            t=t.next;
        }
    }
}
