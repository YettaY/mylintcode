package leetcode.Easy;

/**
 * Created by Administrator on 2016/10/9.
 */
public class Number_of_1_Bits {
    public int hammingWeight(int n) {
        int r=0;
        while(n!=0){
            n&=(n-1);
            r++;
        }
        return r;
    }
}

/*
Solution 2：建8bit表
先说一下填表的原理，根据奇偶性来分析，对于任意一个正整数n

1.如果它是偶数，那么n的二进制中1的个数与n/2中1的个数是相同的，比如4和2的二进制中都有一个1，6和3的二进制中都有两个1。为啥？因为n是由n/2左移一位而来，而移位并不会增加1的个数。
2.如果n是奇数，那么n的二进制中1的个数是n/2中1的个数+1，比如7的二进制中有三个1，7/2 = 3的二进制中有两个1。为啥？因为当n是奇数时，n相当于n/2左移一位再加1。

再说一下查表的原理
对于任意一个32位无符号整数，将其分割为4部分，每部分8bit，对于这四个部分分别求出1的个数，再累加起来即可。而8bit对应2^8 = 256种01组合方式，这也是为什么表的大小为256的原因。
注意类型转换的时候，先取到n的地址，然后转换为unsigned char*，这样一个unsigned int（4 bytes）对应四个unsigned char（1 bytes），分别取出来计算即可。举个例子吧，以87654321（十六进制）为例，先写成二进制形式-8bit一组，共四组，以不同颜色区分，这四组中1的个数分别为4，4，3，2，所以一共是13个1，如下面所示。
10000111 01100101 01000011 00100001 = 4 + 4 + 3 + 2 = 13
class Solution {
public:
    int hammingWeight(uint32_t n) {
        unsigned int table[256]={0};
        for(int i=0;i<256;i++)
            table[i]=(i&1)+table[i>>1];
        return table[n&0xff]+table[(n>>8)&0xff]+table[(n>>16)&0xff]+table[(n>>24)&0xff];
    }
};
Solution 2:建4bit表
class Solution {
public:
    int hammingWeight(uint32_t n) {
        unsigned int table[16] =
        {
            0, 1, 1, 2,
            1, 2, 2, 3,
            1, 2, 2, 3,
            2, 3, 3, 4
        } ;

        unsigned int count =0 ;
        while (n)
        {
            count += table[n &0xf] ;
            n >>=4 ;
        }
        return count ;
    }
};
Solution 3: 平行算法
http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
先将n写成二进制形式，然后相邻位相加，重复这个过程，直到只剩下一位。

int BitCount4(unsigned int n)
{
    n = (n &0x55555555) + ((n >>1) &0x55555555) ;
    n = (n &0x33333333) + ((n >>2) &0x33333333) ;
    n = (n &0x0f0f0f0f) + ((n >>4) &0x0f0f0f0f) ;
    n = (n &0x00ff00ff) + ((n >>8) &0x00ff00ff) ;
    n = (n &0x0000ffff) + ((n >>16) &0x0000ffff) ;

    return n ;
}
*/