package Sort;
import java.io.*;
import java.util.*;
public class InsertSort
{
    public static void main(String args[])
    {
        int[] n={3,7,8,4,1,6,5,2};
        for(int i=1;i<n.length;i++){
        	int j=i-1,t=n[i];
        	while(j>=0 && t<n[j]){
        		n[j+1]=n[j];
        		j--;
        	}
        	n[++j]=t;
        }
        for(int i:n)
        	System.out.println(i);
    }
}