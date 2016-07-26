package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 字符串转换成浮点型
public class StringToDouble {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	public static double trans(String s) {
        boolean f=false,ff=false;
        int i=0;
        double r=0,a=0,b=0.1;
        if(s.charAt(0)=='-'){
        	f=true;
        	i=1;
        }
        if(s.charAt(0)=='+')
        	i=1;
        while(i<s.length()){
        	if(s.charAt(i)>='0' && s.charAt(i)<='9'){
        		if(!ff)
        			a=a*10+s.charAt(i)-'0';
        		else{
        			a=a+(s.charAt(i)-'0')*b;
        			b*=0.1;
        		}
        			
        	}
        	else if(s.charAt(i)=='.'){
        		r=a;
        		a=0;
        		ff=true;
        	}
        	i++;
        }
        return f?-(r+a):(r+a);
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l=new ListNode(1);
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(3);
		ListNode l3=new ListNode(4);
		ListNode l4=new ListNode(5);
		l.next=l1;l1.next=l2;l2.next=l3;l3.next=l4;
		
		int[] nums={1,2,3};
		System.out.println(trans("-345.27467"));
	}

}
