package leetcode.Easy;

/**
 * Created by Administrator on 2016/8/23.
 * 4的幂首先必须大于0
 * 4的幂也是2的幂，所以n&(n-1)等于0
 * 4的幂，二进制表示时，1的位置都是奇数位，0x55555555 = ‭01010101010101010101010101010101‬
 */
public class Power_of_Four {
    public boolean isPowerOfFour(int num) {
        if(num>0 && (num&(num-1))==0 && (num & 0x55555555)!=0)
            return true;
        return false;
    }
}
