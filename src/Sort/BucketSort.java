package Sort;
// 桶排序

public class BucketSort {
	public static void sort(int[] a,int min,int max){
		int[] b=new int[max-min], t=new int[a.length];
        // buckets数组定义了max-min个桶
		 // 计算每个元素在序列出现的次数
		for(int i:a)
			b[i-min]++;
		// 计算“落入”各桶内的元素在有序序列中的位置
		for(int i=1;i<b.length;i++)
			b[i]+=b[i-1];
		   // 将data中的元素完全复制到tmp数组中
		System.arraycopy(a, 0, t, 0, a.length);
		 // 根据buckets数组中的信息将待排序列的各元素放入相应位置
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
