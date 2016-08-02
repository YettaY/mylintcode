package Math;

import java.util.Arrays;

public class bigmultiply {
	public static String multiply(int[] a,int[] b){	
		int fa=1,fb=1,k=0,na=a[a.length-1],nb=b[b.length-1];
		while(na!=0){
			fa*=10;
			na/=10;
		}
		while(nb!=0){
			fb*=10;
			nb/=10;
		}
        int[] r=new int[a.length+b.length];
        for(int i=a.length-1;i>=0;i--){
        	int jina=0, jinb=0, j;
        	for(j=b.length-1;j>=0;j--){
        		long alla=0, allb=0;
        		if(k%2!=0){
        			alla=jina+r[i+j+1]+a[i]*b[j];
        			allb=jinb+r[i+j+1]+a[i]*b[j];
        			
        			r[i+j+1]=(int) (allb%fb);
        			
            		jina=(int) (alla/fa);
            		jinb=(int) (allb/fb);
        		}
        		else{
        			alla=jina+r[i+j+1]+a[i]*b[j];
        			allb=jinb+r[i+j+1]+a[i]*b[j];
        			
        			r[i+j+1]=(int) (alla%fa);
        			
            		jinb=(int) (allb/fb);
            		jina=(int) (alla/fa);                                               
        		}
        		k++;
        	}
        	r[i+j+1]=jina;
        }
        int i=0;
        while(i<r.length-1 && r[i]==0)
        	i++;       
        String s="";
        int j=i;
        while(j<r.length){
        	if(r[j]<10 && j!=i)
        		s+='0';
        	s+=r[j++];
        }
        return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={122,3};
		int[] b={45,63};
		System.out.println(multiply(a, b));
	}

}
