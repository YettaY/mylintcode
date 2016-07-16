package leetcode.Medium;

/**
 * 方程Ax+By=C，A、B、C均为整数，有没有x，y的整数解的模型。
 欧几里得算法的目的是计算两个正整数A、B的最大公约数，计算过程可以描述为：
 1、计算res=A%B，A对B取余；
 2、若res为0，则最大公约数为B；
 3、若res不为0，则进行赋值A=B，B=res，继续第一步。
 如果C能被最大公约数整除，则有办法可以倒水成功；否则就没有办法。
 */
public class Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z==x || z==y || z==x+y)
            return true;
        if (x==0 || y==0 || x+y<z || z% gcd(x,y)!=0)
            return false;
        return true;
    }
    public int gcd(int a,int b){
        return b==0 ? a : gcd(b, a%b);
    }
}
