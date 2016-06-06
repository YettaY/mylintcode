/**
 * Created by Administrator on 2016/6/6.
 */
import java.util.*;
public class s452 {
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null)
            return head;
        ListNode r = new ListNode(0);
        r.next=head;
        while (head != null) {
            if (head.val == val) {
                if (head.next!=null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                }
                else
                    head=null;
            } else
                head = head.next;
        }
        return r.next;
    }
}
