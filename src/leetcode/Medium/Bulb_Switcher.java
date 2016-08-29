package leetcode.Medium;

/**
 * Created by Administrator on 2016/8/29.
 * 对于第i栈灯泡，当i的因子个数为奇数时，最终会保持点亮状态，例如9的因子为1，3，9
 而当i的因子个数为偶数时，最终会保持熄灭状态，例如8的因子为：1，2，4，8
 当且仅当i为完全平方数时，其因子个数为奇数
 为什么只有完全平方数的因子个数为奇数呢？

 因为除了完全平方数，其余数字的因子都是成对出现的，而完全平方数的平方根只会统计一次。
 */
public class Bulb_Switcher {
    public int bulbSwitch(int n) {
        int r=0;
        for(int i=1;i*i<=n;i++)
            r++;
        return r;
    }
}
