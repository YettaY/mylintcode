package Test;
//ϴ���㷨

public class shuffle {
	//���ƣ��������������ĳ���ƽ��н���
	public static void fun1(int[] a){
		for(int i=1;i<a.length;i++){
			int id =(int) Math.floor(Math.random()*(i+1));
			a[i]=a[id];
			a[id]=i;
		}
	}
	//���ƣ�ÿ�γ鵽һ���Ʒŵ���һ����
	public static void fun2(int[] a){
		int[] b=new int[a.length];
		for(int i=a.length,j=0;i>0;i--){
			int id =(int) Math.floor(Math.random()*(i+1));
			b[j++]=a[id];
			a[id]=a[--i];//����յ�λ����δ��������һ���ƶ���
		}
	}
	//����
	public static void fun3(int[] a){
		for(int i=0;i<a.length;i++){
			//ȫ��ϴ��
			//int id =(int) Math.floor(Math.random()*(i+1)); 
			//�ֲ�ϴ�ƣ���ʣ�µ��ƽ��н���
			int id =i+(int) Math.floor(Math.random()*(a.length-i-1));
			int t=a[id];
			a[id]=a[i];
			a[i]=t;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		int[] n=new int[10];
		for(int i=0;i<10;i++)
			n[i]=i;
		fun1(n);
		for(int i:n)
			System.out.print(i+" ");
	}

}
