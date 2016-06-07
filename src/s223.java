import java.util.List;

/**
 * Created by Administrator on 2016/6/7.
 */
public class s223 {
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head==null || head.next==null)
            return true;
        ListNode reverse=reverse(head);
        while (reverse!=null && head!=null){
            if (reverse.val!=head.val)
                return false;
            reverse=reverse.next;
            head=head.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre=head, cur=head.next,nxt=null;
        pre.next=null;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        ListNode r=new ListNode(0);
        r.next=pre;
        return r.next;
    }
    public static void main(String[] args){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(0);
        ListNode n6=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode r=reverse(n1);
        while (r!=null){
            System.out.print(r.val+" ");
            r=r.next;
        }
    }
}
