package Sort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n={3,7,8,4,1,6,5,2};
		for(int i=0;i<n.length;i++){
			for(int j=i+1;j<n.length;j++){
				if(n[i]>n[j]){
					int t=n[i];
					n[i]=n[j];
					n[j]=t;
				}
			}
		}
		for(int i:n)
        	System.out.println(i);
	}

}
