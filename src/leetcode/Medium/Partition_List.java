package leetcode.Medium;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        //Solution 1:
//        if(head==null || head.next==null)
//            return head;
//        ListNode r1=new ListNode(0), r2=new ListNode(0);
//        ListNode p=r1, q=r2;
//        while(head!=null){
//            if(head.val<x){
//                p.next=new ListNode(head.val);
//                p=p.next;
//            }
//            else{
//                q.next=new ListNode(head.val);
//                q=q.next;
//            }
//            head=head.next;
//        }
//        p.next=r2.next;
//        return r1.next;

        //Solution 2:use tail to keep track of the end point where the nodes before it are smaller than x.
        ListNode r=new ListNode(0), cur=r, pre=r;
        r.next=head;
        while(cur!=null && cur.next!=null){
            if (cur.next.val>=x)
                    cur=cur.next;
            else{
                if(cur==pre){
                    pre=pre.next;
                    cur=cur.next;
                }
                else{
                    ListNode t=cur.next;
                    cur.next=t.next;
                    t.next=pre.next;
                    pre.next=t;
                    pre=t;
                }
            }
        }
        return r.next;
    }
}
