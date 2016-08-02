package Test;
import java.util.*;
/**求两个单链表的交点:
 * 1.两个链表都无环：只能是Y型相交形式; 2.一个有环一个无环：不存在; 3.两个都有环：环前相遇情况；环后相遇情况*/
public class intersectList {
	public static class ListNode{
		ListNode next;
		int val;
		public ListNode(int x){
			val=x;
		}
	}
	//第一种情况：判断两个链表是否相交，如果相交且都没有环，则最后一个元素一定相同
	public static boolean isIntersect(ListNode l1, ListNode l2){
		if(l1==null || l2==null)
			return false;
		while(l1.next!=null)
			l1=l1.next;
		while(l2.next!=null)
			l2=l2.next;
		if(l1.val==l2.val)
			return true;
		return false;
	}
	//第一种情况：找交点
	public static ListNode find(ListNode l1,ListNode l2){
		//求两个链表长度差值，长的链表先走差值的步数
		int na=0,nb=0;
		ListNode p1=l1, p2=l2;
		while(p1!=null){
			na++;   p1=p1.next;
		}
		while(p2!=null){
			nb++;   p2=p2.next;
		}
		if(na>nb){
			int c=na-nb;
			while((c--)!=0)
				l1=l1.next;
		}
		else{
			int c=nb-na;
			while((c--)!=0)
				l2=l2.next;
		}
		//同时走，找出相同的位置值
		while(l1!=null && l2!=null && l1.val!=l2.val){
			l1=l1.next;   l2=l2.next;
		}		
		return l1;
	}
	//第三种情况：找到第一个链表的环点，然后将环断开，然后再来遍历第二个链表，如果发现第二个链表从有环变成了无环，那么他们就是相交的
	public static boolean isIntersect2(ListNode l1, ListNode l2){
		ListNode t=findcircle(l1);//找到l1的环入口
		ListNode p=t.next;
		t.next=null;//把l1的环断开
		if(iscircle(l2)){
			t.next=p;
			return false;//若l2还有环，则说明不想交，把l1的环恢复
		}
		else{
			t.next=p;
			return true;
		}
	}
	public static boolean iscircle(ListNode l){
		ListNode slow=l,fast=l;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
				return true;
		}
		return false;
	}
	public static ListNode findcircle(ListNode l){
		ListNode slow=l,fast=l;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast.val==slow.val)
				break;
		}
		slow=l;
		while(slow!=fast){
			slow=slow.next;fast=fast.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l7;l7.next=l8;
		
		ListNode a1=new ListNode(11);
		ListNode a2=new ListNode(12);
		ListNode a3=new ListNode(4);
		ListNode a4=new ListNode(5);
		ListNode a5=new ListNode(8);
		ListNode a6=new ListNode(7);
		a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;a5.next=a6;
		
		ListNode l=find(l1, a1);
		while(l!=null){
			System.out.print(l.val+ " ");
			l=l.next;
		}
	}

}
