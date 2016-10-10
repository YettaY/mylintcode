package leetcode.Easy;

/**
 * Created by Administrator on 2016/9/27.
 * １．找出给定的n落在几位数的范围内

 ２．找到具体落在哪个数字

 ３．找出具体在哪一位上

 分析可以得出一位有９个数字，二位数有90个数字，三位数有900个数，依次类推．
 因此可以每次增加一位数字，看n是否还在这个范围内．例如给定n = 150，首先一位有９个数字，所以位数可以＋１，这样n-9 = 141.
 然后２位的数字有２＊９０= 180，大于１４１，所以目标数字肯定是２位的．然后求具体落在哪个数字．可以用10+(141-1)/2 = 80求出．
 再求具体落在哪一位上，可以用(141-1)%2＝０求出为第０位，即８．
 */
public class Nth_Digit {
    public int findNthDigit(int n) {
        int len=1, start=1; // 数字位数和当前区间的第一个数字
        long cnt=9;//当前区间有多少个数
        while(n > len*cnt){
            n-=len*cnt;
            len++;
            cnt*=10;
            start*=10;
        }
        start+=(n-1)/len;
        return String.valueOf(start).charAt((n-1)%len)-'0';
    }
}
