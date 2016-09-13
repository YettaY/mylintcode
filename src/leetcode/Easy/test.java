package leetcode.Easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2016/9/10.
 */
public class test {
    public static int f(int a, int b, int c){
        return 0;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=Integer.valueOf(in.nextLine());
        boolean[] a=new boolean[n];
        int c=0;
        for(int i=2;i<n;i++){
            if(!a[i]){
                for(int j=2;i*j<n;j++)
                    a[i*j]=true;

            }
        }
        for(int i=2;i<=n/2;i++)
            if(!a[i] && !a[n-i])
                c++;
        System.out.printf("%d\n",c);
    }

}
