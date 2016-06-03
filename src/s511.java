import java.util.*;
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
/**
 * Created by Administrator on 2016/6/3.
 */
public class s511 {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head==null || head.next==null)
            return head;
        ListNode r=new ListNode(0);
        ListNode p1=r,p2=r,cur=r;
        cur.next=head;
        while(cur.next!=null){
            if (cur.next.val==v1)
                p1=cur;
            else if (cur.next.val==v2)
                p2=cur;
            cur=cur.next;
        }

        if ( (p1==r&&p1.next.val!=v1) || (p2==r&&p2.next.val!=v2))
            return head;
        ListNode t1=p1.next;
        p1.next=p2.next;
        p2.next=t1;
        ListNode t2=t1.next;
        t1.next =p1.next.next;
        p1.next.next=t2;
        return r.next;
    }
}
