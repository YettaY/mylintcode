package Test;
import java.util.*;
/**������������Ľ���:
 * 1.���������޻���ֻ����Y���ཻ��ʽ; 2.һ���л�һ���޻���������; 3.�������л�����ǰ��������������������*/
public class intersectList {
	public static class ListNode{
		ListNode next;
		int val;
		public ListNode(int x){
			val=x;
		}
	}
	//��һ��������ж����������Ƿ��ཻ������ཻ�Ҷ�û�л��������һ��Ԫ��һ����ͬ
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
	//��һ��������ҽ���
	public static ListNode find(ListNode l1,ListNode l2){
		//�����������Ȳ�ֵ�������������߲�ֵ�Ĳ���
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
		//ͬʱ�ߣ��ҳ���ͬ��λ��ֵ
		while(l1!=null && l2!=null && l1.val!=l2.val){
			l1=l1.next;   l2=l2.next;
		}		
		return l1;
	}
	//������������ҵ���һ������Ļ��㣬Ȼ�󽫻��Ͽ���Ȼ�����������ڶ�������������ֵڶ���������л�������޻�����ô���Ǿ����ཻ��
	public static boolean isIntersect2(ListNode l1, ListNode l2){
		ListNode t=findcircle(l1);//�ҵ�l1�Ļ����
		ListNode p=t.next;
		t.next=null;//��l1�Ļ��Ͽ�
		if(iscircle(l2)){
			t.next=p;
			return false;//��l2���л�����˵�����뽻����l1�Ļ��ָ�
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
