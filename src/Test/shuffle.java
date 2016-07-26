package Test;
//洗牌算法

public class shuffle {
	//插牌，最大的牌与随机的某张牌进行交换
	public static void fun1(int[] a){
		for(int i=1;i<a.length;i++){
			int id =(int) Math.floor(Math.random()*(i+1));
			a[i]=a[id];
			a[id]=i;
		}
	}
	//抽牌，每次抽到一张牌放到另一个组
	public static void fun2(int[] a){
		int[] b=new int[a.length];
		for(int i=a.length,j=0;i>0;i--){
			int id =(int) Math.floor(Math.random()*(i+1));
			b[j++]=a[id];
			a[id]=a[--i];//被抽空的位置由未被抽的最后一张牌顶替
		}
	}
	//换牌
	public static void fun3(int[] a){
		for(int i=0;i<a.length;i++){
			//全局洗牌
			//int id =(int) Math.floor(Math.random()*(i+1)); 
			//局部洗牌，和剩下的牌进行交换
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
