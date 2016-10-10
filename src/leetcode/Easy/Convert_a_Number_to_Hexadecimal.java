package leetcode.Easy;

/**
 * Created by Administrator on 2016/9/27.
 */
public class Convert_a_Number_to_Hexadecimal {
    public static String toHex(int num) {
        if(num==0)
            return "0";
        String r="";
        while(num!=0){
            int cur=num&15;
            if(cur>=10)
                r=(char)(cur-10+'a')+r;
            else
                r=cur+r;
            num>>>=4;  //无符号右移
        }
        return r;
    }
    public static void main(String[] args){
       // toHex(26);
        System.out.println(toHex(-1));
    }
}
