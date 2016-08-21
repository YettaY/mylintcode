package leetcode.Easy;

/**
 * Created by yanglu on 16/7/14.
 */
public class Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        if(b==0)
            return a;
        int sum,carry;
        sum=a^b; //加法
        carry=(a&b)<<1;//进位
        return getSum(sum,carry);
    }
}
