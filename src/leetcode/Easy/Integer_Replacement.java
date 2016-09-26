package leetcode.Easy;

/**
 * Created by Administrator on 2016/9/26.
 * 我们也可以使用迭代的解法，那么这里就有小技巧了，当n为奇数的时候，我们什么时候应该加1，什么时候应该减1呢，通过观察来说，除了3和7意外，所有加1就变成4的倍数的奇数，适合加1运算，比如15:

 15 -> 16 -> 8 -> 4 -> 2 -> 1

 15 -> 14 -> 7 -> 6 -> 3 -> 2 -> 1

 对于7来说，加1和减1的结果相同，我们可以不用管，对于3来说，减1的步骤小，所以我们需要去掉这种情况。那么我们如何知道某个数字加1后是否是4的倍数呢，我们可以用个小技巧，由于我们之前判定其是奇数了，那么最右边一位肯定是1，如果其右边第二位也是1的话，那么进行加1运算，进位后右边肯定会出现两个0，则一定是4的倍数，搞定。如果之前判定是偶数，那么除以2即可
 */
public class Integer_Replacement {
    public static int integerReplacement(int n) {
        //Solution 1:
//        if(n==1)
//            return 0;
//        if(n==Integer.MAX_VALUE)
//            return 32;
//        if(n%2==0)
//            return integerReplacement(n/2)+1;
//        else
//            return Math.min(integerReplacement(n-1)+1, integerReplacement(n+1)+1);

        //Solution 2:
        if(n==1)
            return 0;
        if(n==Integer.MAX_VALUE)
            return 32;
        int r=0;
        while(n>1){
            r++;
            if((n&1)==1){
                if( (n&2)!=0 && n!=3 )
                    n++;
                else
                    n--;
            }
            else
                n>>=1;
        }
        return r;
    }
    public static void main(String[] args){
        System.out.println(integerReplacement(2147483647));  //最大的数要经过32次才能变成1
    }
}
