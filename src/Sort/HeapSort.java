package Sort;

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





    public static void sort(Comparable[] data) {
            // 构建最大堆
            buildMaxHeap(data);
            // 循环，每次把根节点和最后一个节点调换位置
            for (int i = data.length; i > 1; i--) {
                Comparable tmp = data[0];
                data[0] = data[i - 1];
                data[i - 1] = tmp;

                // 堆的长度减少1，排除置换到最后位置的根节点
                maxHeapify(data, 1, i - 1);
            }
        }

        // 根据输入数组构建一个最大堆
        private static void buildMaxHeap(Comparable[] data) {
            for (int i = data.length / 2; i > 0; i--) {
                maxHeapify(data, i, data.length);
            }
        }

        //堆调整，使其生成最大堆
        private static void maxHeapify(Comparable[] data, int parentNodeIndex, int heapSize) {
            // 左子节点索引
            int leftChildNodeIndex = parentNodeIndex * 2;
            // 右子节点索引
            int rightChildNodeIndex = parentNodeIndex * 2 + 1;
            // 最大节点索引
            int largestNodeIndex = parentNodeIndex;

            // 如果左子节点大于父节点，则将左子节点作为最大节点
            if (leftChildNodeIndex <= heapSize && data[leftChildNodeIndex - 1].compareTo(data[parentNodeIndex - 1]) > 0) {
                largestNodeIndex = leftChildNodeIndex;
            }

            // 如果右子节点比最大节点还大，那么最大节点应该是右子节点
            if (rightChildNodeIndex <= heapSize && data[rightChildNodeIndex - 1].compareTo(data[largestNodeIndex - 1]) > 0) {
                largestNodeIndex = rightChildNodeIndex;
            }

            // 最后，如果最大节点和父节点不一致，则交换他们的值
            if (largestNodeIndex != parentNodeIndex) {
                Comparable tmp = data[parentNodeIndex - 1];
                data[parentNodeIndex - 1] = data[largestNodeIndex - 1];
                data[largestNodeIndex - 1] = tmp;

                // 交换完父节点和子节点的值，对换了值的子节点检查是否符合最大堆的特性
                maxHeapify(data, largestNodeIndex, heapSize);
            }
        }
}
