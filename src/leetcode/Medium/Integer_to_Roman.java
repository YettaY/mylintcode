package leetcode.Medium;

/**
 * Created by Administrator on 2016/9/13.
 */
public class Integer_to_Roman {
    /**1-3999对应如下
     * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     * 1000~3000: {"M", "MM", "MMM"}.
     * */
    public static String intToRoman(int num) {
        String[][] str={
                {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"","M", "MM", "MMM"}};
        String res="";
        int i=0;
        while(num!=0){
            int n=num%10;
            res=str[i++][n]+res;
            num/=10;
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(intToRoman(1000));
    }

}
