package leetcode.Hard;

/**
 * Created by Administrator on 2016/9/5.
 * 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况:
 case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
 case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
 case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.
 */
public class Number_of_Digit_One {
    public int countDigitOne(int n) {
        int r=0, high=n, factor=1, low=0;
        while(high>0){
            int cur=high%10;
            high/=10;
            if(cur==0)
                r+=high*factor;
            else if(cur==1)
                r+=high*factor+low+1;
            else
                r+=(high+1)*factor;
            low+=cur*factor;
            factor*=10;
        }
        return r;
    }
}
