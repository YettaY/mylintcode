package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/25.
 * 如何快速的判断某一个字符串是否所有的元素都已经满足了至少出现k次这个条件，
 *用mask就很好的解决了这个问题，由于字母只有26个，而整型mask有32位，足够用了，
 * 每一位代表一个字母，如果为1，表示该字母不够k次，
 * 如果为0就表示已经出现了k次，这种思路真是太聪明了.
 * 我们遍历字符串，对于每一个字符，我们都将其视为起点，然后遍历到末尾，我们增加哈希表中字母的出现次数，
 * 如果其小于k，我们将mask的对应位改为1，
 * 如果大于等于k，将mask对应位改为0。然后看mask是否为0，
 * 是的话就更新res结果，然后把当前满足要求的子字符串的起始位置j保存到max_idx中，
 * 等内层循环结束后，将外层循环变量i赋值为max_idx+1，继续循环直至结束
 */
public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    public static int longestSubstring(String s, int k) {
        //Solution 1:
//        int[] c=new int[26];
//        for (int i=0;i<s.length();i++)
//            c[s.charAt(i)-'a']++;
//        int max=0, i=0;
//        while(i+k<s.length()){
//            int[] m=new int[26];
//            int last=i, mask=0;
//            for(int j=i;j<s.length();j++){
//                int t=s.charAt(j)-'a';
//                m[t]++;
//                if(m[t]<k)
//                    mask |= (1<<t);
//                else
//                    mask &= (~(1<<t));
//                if(mask==0){
//                    max= Math.max(j-i+1, max);
//                    last=j;
//                }
//            }
//            i=last+1;
//        }
//        return max;

        //Solution 2:
//        int[] c=new int[128];
//        for (int i=0;i<s.length();i++)
//            c[s.charAt(i)]++;
//        boolean ok=true;
//        int max=0, last=0;
//        for(int i=0;i<s.length();i++){
//            if(c[s.charAt(i)] <k){
//                max=Math.max(max, longestSubstring(s.substring(last, i), k));
//                ok=false;
//                last=i+1;
//            }
//        }
//        return ok ? s.length() : Math.max(max,longestSubstring(s.substring(last, s.length()), k) );

        //Solution 3:  3ms fast
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    public static int helper (char[] str, int s, int e, int k){
        if(e<s || e-s<k)
            return 0;
        int[] c=new int[26];
        for(int i=s;i<e;i++)
            c[str[i]-'a']++;
        for(int i=0;i<26;i++){
            if(c[i]==0) //not exists
                continue;
            if(c[i]<k){
                for(int j=s;j<e;j++) {
                    if(str[j]==i+'a'){
                        int left=helper(str, s, j, k);
                        int right=helper(str, j+1, e, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return e-s;
    }
    public static void main(String[] args){
        System.out.println(longestSubstring("aaabbb", 3));
    }
}
