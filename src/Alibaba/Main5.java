package Alibaba;
import java.util.*;
/**
 * 功能：将一个数从M进制转换成N进制
 * MValue：M进制数的字符串表示方法
 * Shang：保存中间运算结果
 * M：M进制     N：N进制
 */
public class Main5 {
    // 在这里对输入赋值
    public static String Shang = null;
    public static int M = 10;
    public static int N;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String val=String.valueOf(in.nextLong());
        N=in.nextInt();
        String nValue = "";
        Shang = val;
        while(Shang.length() > 0)
            nValue = qiuyu(Shang) + nValue;
        System.out.println(nValue);
    }
    //功能：对给定的M进制字符串对n求余。
    public static String qiuyu(String s) {
        Shang = "";
        int r = 0;
        while (s.length() > 0) {
            int t = getIntFromStr(s.substring(0, 1));
            s = s.substring(1);
            r = r * M + t;
            Shang += getStrFromInt(r / N);
            r = r % N;
        }
        while(Shang.length() > 0 && Shang.charAt(0) == '0'){
            Shang = Shang.substring(1);
        }
        return getStrFromInt(r);
    }
    public static int getIntFromStr(String str){
        return str.charAt(0) <= '9' && str.charAt(0) >= '0'?
                str.charAt(0) - '0' : str.charAt(0) - 'A' + 10;
    }
    public static String getStrFromInt(int value){
        String result = null;
        if(value>=0 && value<=9)
            result = String.valueOf((char)('0' + value));
        else if(value > 9 && value <36)
            result = String.valueOf((char)('A' + value - 10));
        else
            result = "-1";// 出错误了
        return result;
    }
}
