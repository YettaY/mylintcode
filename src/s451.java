/**
 * Created by Administrator on 2016/6/7.
 */

public class s451 {
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head==null || head.next==null)
            return head;
        ListNode r=new ListNode(0);
        r.next=head;
        head=r;
        while(head.next!=null && head.next.next!=null){
            ListNode n1=head.next, n2=head.next.next;
            head.next=n2;
            n1.next=n2.next;
            n2.next=n1;
            head=n1;
        }
        return r.next;
    }
}
