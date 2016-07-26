package Sort;

public class MergeSort {
	public static void merge(int[] n,int l,int m,int h){
		int[] t=new int[h-l+1];
		int i=l,j=m+1,k=0;
		while(i<=m && j<=h){
			if(n[i]<=n[j])
				t[k++]=n[i++];
			else
				t[k++]=n[j++];
		}
		while(i<=m)
			t[k++]=n[i++];
		while(j<=h)
			t[k++]=n[j++];
		for(i=0;i<t.length;i++)
			n[i+l]=t[i];
	}
	public static void sort(int[] n,int i,int j){
		int m=(i+j)/2;
		if(i<j){
			sort(n, i, m);
			sort(n, m+1, j);
			merge(n, i,m,j);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n={3,7,8,4,1,6,5,2};
        sort(n,0,n.length-1);
        for(int k:n)
        	System.out.println(k);
	}

}
