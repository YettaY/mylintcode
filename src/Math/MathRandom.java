package Math;

import java.util.Random;

//һ��������ÿ�������a��b���������ɴκ������a,b�ĸ�������ͬ�ġ�
public class MathRandom {
	public static double ra=0.5;
	public static double rb=0.5;
	public char output()
	{
//		double t=Math.random();
//		if(t>=0 && t<=ra)
//			return 'a';
//		else if(t>ra && t<=ra+rb)
//			return 'b';
//		return (char) -1;
		int a=new Random().nextInt(2);
		int b=new Random().nextInt(2);
		if(a==0&&b==1)
			return 'a';
		else if(a==1&&b==0)
			return 'b';
		else
			return output();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MathRandom a=new MathRandom();
//		for(int i=0;i<10;i++)
//		{
//			System.out.print(a.output()+" ");
//		}
		//random-��[min,max]��Χ����
		Random r=new Random();
		int min=0,max=2;
		for(int i=0;i<10;i++)
			System.out.println( (r.nextInt(max)%(max-min+1)+min) );
	}
}