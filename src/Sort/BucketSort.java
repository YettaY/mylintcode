package Sort;
// Ͱ����

public class BucketSort {
	public static void sort(int[] a,int min,int max){
		int[] b=new int[max-min], t=new int[a.length];
        // buckets���鶨����max-min��Ͱ
		 // ����ÿ��Ԫ�������г��ֵĴ���
		for(int i:a)
			b[i-min]++;
		// ���㡰���롱��Ͱ�ڵ�Ԫ�������������е�λ��
		for(int i=1;i<b.length;i++)
			b[i]+=b[i-1];
		   // ��data�е�Ԫ����ȫ���Ƶ�tmp������
		System.arraycopy(a, 0, t, 0, a.length);
		 // ����buckets�����е���Ϣ���������еĸ�Ԫ�ط�����Ӧλ��
		for(int i=a.length-1;i>=0;i--)
			a[--b[t[i]-min]]=t[i];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={5, 3, 6, 2, 1, 9, 4, 4, 4, 8, 7 };
		sort(a, 0, 10);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");

	}

}
