package Test;
import java.util.*;
//�������ƽ��㣬�õ���������Ԫ��֮�͵��ڸõ��ұ�����Ԫ��֮��

public class EqualPoint {
	public static int find(int[] n)
	{
		if(n==null || n.length==0)
			return -1;
		long sum=0;
		for(int i:n)
			sum+=i;
		long left=0;
		for(int i=0;i<n.length;i++)
		{
			long right=sum-left-n[i];
			if(left==right){
				System.out.println(i);//ƽ���
			}
			left+=n[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n={-7,1,5,2,-4,3,0};
		int[] m={1,0};
		System.out.println(find(m));
	}

}
