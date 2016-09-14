package leetcode.Easy;
import java.util.*;
/**
 * Created by Administrator on 2016/9/13.
 *
 /**罗马数字基本字符有7个：I，V，X，L，C，D，M，分别表示1，5，10，50，100，500，1000。
 在构成数字的时候，有下列规则：
 1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ= 3；
 2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ= 8；Ⅻ= 12；
 3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ=4；Ⅸ=9；
 4、正常使用时，连写的数字重复不得超过三次。
 CXCIX - 199  DCLXVI - 666  MCMXCIX - 1,999  XXIX - 29  XVIII – 18  XCIX - 99
 从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数。
 */

public class Roman_to_Integer {
    public static int romanToInt(String s) {
        Map<Character, Integer> map =new HashMap<Character,Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int r=map.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(map.get(s.charAt(i-1))<map.get(s.charAt(i)))
                r+=map.get(s.charAt(i))-2*map.get(s.charAt(i-1));
            else
                r+=map.get(s.charAt(i));
        }
        return r;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(romanToInt("MCMXCIX"));
    }
}
