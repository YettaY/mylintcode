package Sort;
import java.util.*;
//ÇótopN

public class topN {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={101, 2, 3, 4, 5, 6, 7, 8, 11, 9, 10, 100};
		int n=5;
		if(a.length<n)
			return;
		
		Queue<Integer> q=new PriorityQueue<Integer>(5,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;//×îÐ¡¶Ñ101, 2, 3, 4, 5, 6, 7, 8, 11, 9, 10, 100
			}
			
		});
		for(int i=0;i<n;i++)
			q.add(a[i]);
		for(int i=n;i<a.length;i++){
			if(a[i]>q.peek()){
				q.poll();
				q.add(a[i]);
			}
		}
		while(!q.isEmpty())
			System.out.print(q.poll()+" ");
	}

}
