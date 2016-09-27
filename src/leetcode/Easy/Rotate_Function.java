package leetcode.Easy;

/**
 * Created by Administrator on 2016/9/26.
 *
 * F(1)-F(0)=(1-0)*A[0]+(2-1)*A[1]+(3-2)*A[2]+(0-3)*A[3]
 F(2)-F(1)=(2-1)*A[0]+(3-2)*A[1]+(0-3)*A[2]+(1-0)*A[3]
 F(3)-F(2)=(3-2)*A[0]+(0-3)*A[1]+(1-0)*A[2]+(2-1)*A[3]

 sum = A[0]+…+A[length-1]
 F(n)-F(n-1)=-(length-1)*A[length-n]+sum-A[length-n]=-length*A[length-n]+sum

 F(n)=F(n-1)-length*A[length-n]+sum
 */
public class Rotate_Function {
    public int maxRotateFunction(int[] A) {
        if(A==null || A.length==0)
            return 0;

        //o(n^2) 超时
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<A.length;i++){
//            int r=0;
//            for(int j=0;j<A.length;j++)
//                r+=j*A[(i+j)%A.length];
//            max=Math.max(max, r);
//        }
//        return max;

        //Solution 2:
        int sum=0, f0=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            f0+=i*A[i];
        }
        int max=f0;
        for(int i=1;i<A.length;i++){
            f0 = f0 + sum-A.length*A[A.length-i];
            max=Math.max(f0, max);
        }
        return max;
    }
}
