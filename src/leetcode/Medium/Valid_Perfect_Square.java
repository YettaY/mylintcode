package leetcode.Medium;

/**
 * Created by Administrator on 2016/7/16.
 */
public class Valid_Perfect_Square {
    public static boolean isPerfectSquare(int num) {
        if (num<1)
            return false;
        long l=1, h=num;
        while(l <= h){
            long m=l+(h-l)/2;//(l+h)/2;
            if (m*m == num)
                return true;
            if (m*m < num)
                l=m+1;
            else
                h=m-1;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }
}
