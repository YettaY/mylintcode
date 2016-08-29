package leetcode.Medium;

/**
 * Created by Administrator on 2016/8/28.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        //Solution 1:
//        if(head==null)
//            return head;
//        ListNode odd=head, even=head.next, evenhead=even;
//        while(even!=null && even.next!=null){
//            odd.next=odd.next.next;
//            even.next=even.next.next;
//            odd=odd.next;
//            even=even.next;
//        }
//        odd.next=evenhead;
//        return head;

        //Soltion 2:
        ListNode odd=new ListNode(0);
        ListNode even=new ListNode(0);
        ListNode ro=odd,re=even;
        int f=0;
        if(head==null)
            return null;
        while(head!=null){
            if(f%2!=0){
                ro.next=new ListNode(head.val);
                ro=ro.next;
            }
            else{
                re.next=new ListNode(head.val);
                re=re.next;
            }
            f++;
            head=head.next;
        }
        re.next=odd.next;

//		ListNode t=even.next;
//		while(t!=null){
//			System.out.print(t.val+" ");
//			t=t.next;
//		}
        return even.next;
    }
}
