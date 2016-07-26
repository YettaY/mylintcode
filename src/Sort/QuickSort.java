package Sort;

public class QuickSort {
	public static int partition(int[] n,int i,int j){
		int t=n[i];
		while(i<j){
			while(i<j && n[j]>=t)
				j--;
			n[i]=n[j];
			while(i<j && n[i]<=t)
				i++;
			n[j]=n[i];
		}
		n[i]=t;
		return i;
	}
	public static void sort(int[] n,int i,int j){
		if(i<j){
			int p=partition(n, i, j);
			sort(n, i, p-1);
			sort(n, p+1, j);
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
