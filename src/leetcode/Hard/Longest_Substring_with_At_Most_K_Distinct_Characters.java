package leetcode.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanglu on 16/8/5.
 * http://chuansong.me/n/2845011
 * 给定一个字符串，找到最长的包含最多k个不同字符的子串，输出最长子串的长度即可。
 Example：
 给出字符串”eceba”，k = 2
 输出答案3，最长包含最多2个不同字符的子串为”ece”
 分析解答
 最暴力的做法是穷举所有可能的子串，一共有n^2级别个不同的子串，然后对于每一个子串统计有多少不同的字符，如果少于k个就更新答案。这是一个三重循环的穷举，复杂度是O(n^3)。聪明的读者肯定想到了第二重和第三重循环可以合并，因为之前的统计信息可以继续使用而不需要每一次重新统计。这样的话穷举子串的开始位置和结束位置，复杂度是O(n^2)。如果在面试时提出了这个算法，面试官首先会表示认同，然后希望你进行优化。我们来看看如何进行优化。
 在统计的过程中我们可以发现，当穷举的开始位置改变时我们会选择重新统计，但其实当开始位置改变时，我们之前记录的大部分信息都是有用的，我们只需在原有的统计结果上稍作修改。也就是说，我们需要维护两个指针，一个指向子串的开始位置，一个指向子串的结束位置，同时维护一个变量记录两个指针之间有多少个不同的字符。在穷举的过程中，始终保持两个指针之间的不同字符数最大且不超过k。
 分析一下这个算法的时间复杂度，虽然我们会用到两重循环（请看参考程序），但是因为这两个指针只增不减，每次循环指针增加1，因此while循环总共只会进入n次（n = s.length( ))，所以时间复杂度是O(n)。
 */
public class Longest_Substring_with_At_Most_K_Distinct_Characters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k){
//        int maxlen=0;
//        Map<Character,Integer> map=new HashMap<>();
//        int i,j=0;
//        char c;
//        for(i=0;i<s.length();i++){
//            while(j<s.length()){
//                c=s.charAt(j);
//                if (map.containsKey(c))
//                    map.put(c,map.get(c)+1);
//                else{
//                    if (map.size()==k)
//                        break;
//                    map.put(c,1);
//                }
//                j++;
//            }
//            maxlen=Math.max(maxlen, j-i);
//            c=s.charAt(i);
//            if (map.containsKey(c)){
//                if (map.get(c)>1)
//                    map.put(c,map.get(c)-1);
//                else
//                    map.remove(c);
//            }
//        }
//        return maxlen;


        //Solution2:sliding window
        int maxLen = 0;
        int l = 0, r = 0, cnt = 0;                     // cnt is number of unique chars between l and r
        int[] chars = new int[128];                    // chars is hash map for each char's freq
        while (r < s.length()) {
            if (chars[s.charAt(r)] == 0) {             // adjust l position if next char is not in current char set
                cnt++;
                while (l <= r && cnt > k) {
                    chars[s.charAt(l)]--;
                    if (chars[s.charAt(l)] == 0) {     // break loop if left char is unique in hash map
                        cnt--;
                    }
                    l++;
                }
            }
            chars[s.charAt(r)]++;
            r++;
            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}
