package Math;
import java.util.*;
/**
 * ���ܣ���һ������M����ת����N����
 * MValue��M���������ַ�����ʾ����
 * Shang�������м�������
 * M��M����     N��N����
 */
public class M2N {
    // ����������븳ֵ
    public static String MValue = "62";
    public static String Shang = null;
    public static int M = 10;
    public static int N = 16;
 
    public static void main(String[] args) {
        String nValue = "";
        Shang = MValue;
        while(Shang.length() > 0)
            nValue = qiuyu(Shang) + nValue;
        System.out.println(nValue);
    }
 //���ܣ��Ը�����M�����ַ�����n���ࡣ
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
            str.charAt(0) - '0' : str.charAt(0) - 'a' + 10;
    }
    public static String getStrFromInt(int value){
        String result = null;
        if(value>=0 && value<=9)
            result = String.valueOf((char)('0' + value));
        else if(value > 9 && value <36)
            result = String.valueOf((char)('a' + value - 10));
        else
            result = "-1";// ��������
        return result;
    }
}
