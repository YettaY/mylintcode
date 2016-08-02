package Test;
import java.util.*;
//找数组的平衡点，该点的左边所有元素之和等于该点右边所有元素之和

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
				System.out.println(i);//平衡点
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
