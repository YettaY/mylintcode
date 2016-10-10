package leetcode.Medium;

/**
 * Created by Administrator on 2016/9/27.
 */
public class Remove_K_Digits {
    public static String removeKdigits(String num, int k) {
        int last=num.length()-k;
        if(last==0)
            return "0";
        char[] r=new char[last];
        for(int i=0,j=0;i<num.length();i++){
            while(num.length()-i+j>last && j>0 && r[j-1]>num.charAt(i))
                j--;
            if(j<last)
                r[j++]=num.charAt(i);
        }
        int i=0;
        while(i<r.length-1 && r[i]=='0')
            i++;
        return new String(r,i,r.length-i);
    }
    public static void main(String[] args){
        System.out.println(removeKdigits("10200", 1));
    }
}
