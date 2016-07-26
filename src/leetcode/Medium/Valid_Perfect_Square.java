package leetcode.Medium;

/**
1. a square number is 1+3+5+7+... Time Complexity O(sqrt(N)) (Credit to lizhibupt, thanks for correcting this).
2. binary search. Time Complexity O(logN)
3. 牛顿迭代法求平方根 Time Complexity is close to constant, given a positive integer.
*/
public class Valid_Perfect_Square {
    public static boolean isPerfectSquare(int num) {
        if (num<1)
            return false;

        // Solution 1:
//        for(int i=1;num>0;i+=2){
//            num -=i;
//        }
//        return num==0;

        //Solution 2:

//        long l=1, h=num;
//        while(l <= h){
//            long m=l+(h-l)/2;//(l+h)/2;
//            if (m*m == num)
//                return true;
//            if (m*m < num)
//                l=m+1;
//            else
//                h=m-1;
//        }
//        return false;


        //Solution3:
        long t=num;
        while(t*t > num)
            t=(t+num/t)/2;
        return t*t==num;
    }
    public static void main(String[] args){
        System.out.println(isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }
}
