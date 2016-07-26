package Sort;
/**
 * �����ʼ��
��ʼ���ѵ�ʱ���Ƕ����еķ�Ҷ�ӽ�����ɸѡ��
���һ�����ն�Ԫ�ص��±���[n/2]����ȡ��������ɸѡֻ��Ҫ�ӵ�[n/2]����ȡ����Ԫ�ؿ�ʼ���Ӻ���ǰ���е�����
���磬����һ�����飬���ȸ��ݸ�����Ԫ�ع���һ����ȫ��������
Ȼ������һ����Ҷ�ӽ�㿪ʼ��ÿ�ζ��ǴӸ���㡢���ӡ��Һ����н��бȽϽ������������ܻ������ӽ�㲻����ѵ����ʣ�����ÿ�ν���֮����Ҫ���¶Ա������ĺ��ӽ����е�����
���ж�����
�������˳�ʼ��֮��Ϳ��Խ��������ˡ�
��������һ��ѡ�����򡣽����ĳ�ʼ��Ϊ��ʼ����������
����ʼ����������Ѷ�Ԫ�أ���Ϊ������ֵ�������Ѷ�Ԫ�غ����һ��Ԫ�ؽ�������������n��λ�ã������һ��λ�ã���Ϊ��������ǰn-1��λ�������������������������е������õ���֮���ٽ����Ѷ������һ��Ԫ�أ��������������ȱ�Ϊ2������
���Ͻ��д˲�������ʣ�µ�Ԫ�����µ���Ϊ�ѣ�Ȼ������Ѷ�Ԫ�ص���������ÿ�ν���������������-1��������+1�������ظ��˹���ֱ����������������Ϊn-1��������ɡ�*/
public class HeapSort {
	public static void swap(int[] a,int i,int j)
    {
        if(i==j)
        {
            return;
        }
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void heap(int[] a,int last)
    {
        for(int i=(last-1)/2;i>=0;i--)
        {
        	int k=i;
        	while(2*k+1<=last)
        	{
        		int big=2*k+1;
        		while(big<last && a[big]<a[big+1])
        			big++;
        		if(a[big]>a[k])
        			swap(a,big,k);
        		else
        			break;
        	}
        }
    }
    public static void heapify(int[] A) {
        // write your code here
        if(A==null || A.length==0)
            return;
        for(int i=0;i<A.length;i++)
        {
            heap(A,A.length-1-i);
            swap(A,0,A.length-1-i);
        }
        
    }
//	private static void siftup(int[] A, int k) {
//        while (k != 0) {
//            int father = (k - 1) / 2;
//            if (A[k] > A[father]) {
//                break;
//            }
//            int temp = A[k];
//            A[k] = A[father];
//            A[father] = temp;
//            
//            k = father;
//        }
//    }
//    
//    public static void heapify(int[] A) {
//        for (int i = 0; i < A.length; i++) {
//            siftup(A, i);
//        }
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n={3,7,8,4,1,6,5,2};
        heapify(n);
        for(int i=0;i<n.length;i++)
        	System.out.print(n[i]+" ");
	}

}
