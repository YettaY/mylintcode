package leetcode.Medium;
import java.util.*;
/**
 * 这道题需要计算 a^b % c 的值，其中b非常的大，大到只能使用数组来表示。
 * 这个公式的意思就是，(a*b)%c=(a%c)*(b%c),因此我们可以在每一步计算结果之后都这么处理，防止溢出。
 * 类似于二分的分割，比如当b是偶数的时候，我们可以转化为计算a^（b/2)后再平方，而对于基础，则再乘一个a就可以
 *
 * 第三种方法: https://discuss.leetcode.com/topic/50504/java-4ms-solution-using-the-remainder-repeat-pattern/2
 */
public class Super_Pow {
    public int superPow(int a, int[] b) {
        if (b==null || b.length==0)
            return a;
        a%=1337;
        int r=1;
        for (int i=b.length-1;i>=0;i--){
            // Solution1
          //  r=r*myPow1(a,b[i])%1337;
           // a=myPow1(a,10);



            // Solution2
            r=r*myPow2(a,b[i])%1337;
            a=myPow2(a,10);
        }
        return r;
    }
    public int myPow2(int x, int n){
        int r=1;
        while(n!=0){
            if (n%2!=0)
                r=r*x%1337;
            x=x*x%1337;
            n/=2;
        }
        return r;
    }
    public int myPow1(int x, int n) {
        if(n==0)
            return 1;
        if(n==1)
            return x;
        int n1=n/2,n2=n-n1*2;
        double t1=myPow1(x, n1);
        double t2=myPow1(x, n2);
        return (int) ((int)t1*t1*t2%1337);
    }
}
