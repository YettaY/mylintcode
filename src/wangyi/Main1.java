package wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 食量m 和 菜个数n
 * n行,每行两个数,表示菜量a和满意度b
 * 求最大满意度,0/1背包问题
 * Created by yanglu on 16/8/2.
 */
class node{
    int id, a, b;
    public node(int id,int a,int b){
        this.id=id;
        this.a=a;
        this.b=b;
    }
}
public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m=in.nextInt(), n=in.nextInt();
        node[] x=new node[n];
        for(int i=0;i<n;i++){
            int a=in.nextInt(), b=in.nextInt();
            x[i]=new node(i,a,b);
        }
        Arrays.sort(x, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if (o1.b!=o2.b)
                    return o2.b-o1.b;
                return o1.a-o2.a;
            }
        });
        int[] dp=new int[m+1];
        for(int i=0;i<n;i++){
            for(int j=m;j>=x[i].a;j--){
                if (dp[j-x[i].a]+x[i].b>dp[j])
                    dp[j]=dp[j-x[i].a]+x[i].b;
            }
        }

        System.out.println(dp[m]);
    }
}
