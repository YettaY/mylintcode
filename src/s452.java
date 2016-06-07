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
        head=r;
        while (head.next != null) {
            if (head.next.val == val)
                head.next=head.next.next;
            else
                head = head.next;
        }
        return r.next;
    }
}
