package Sort;
/**
 * 构造初始堆
初始化堆的时候是对所有的非叶子结点进行筛选。
最后一个非终端元素的下标是[n/2]向下取整，所以筛选只需要从第[n/2]向下取整个元素开始，从后往前进行调整。
比如，给定一个数组，首先根据该数组元素构造一个完全二叉树。
然后从最后一个非叶子结点开始，每次都是从父结点、左孩子、右孩子中进行比较交换，交换可能会引起孩子结点不满足堆的性质，所以每次交换之后需要重新对被交换的孩子结点进行调整。
进行堆排序
　　有了初始堆之后就可以进行排序了。
堆排序是一种选择排序。建立的初始堆为初始的无序区。
排序开始，首先输出堆顶元素（因为它是最值），将堆顶元素和最后一个元素交换，这样，第n个位置（即最后一个位置）作为有序区，前n-1个位置仍是无序区，对无序区进行调整，得到堆之后，再交换堆顶和最后一个元素，这样有序区长度变为2。。。
不断进行此操作，将剩下的元素重新调整为堆，然后输出堆顶元素到有序区。每次交换都导致无序区-1，有序区+1。不断重复此过程直到有序区长度增长为n-1，排序完成。*/
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
