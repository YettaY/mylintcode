package leetcode.Hard;

/**
 * Created by yanglu on 16/9/4.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,
 Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 Note:
 Because the range might be a large number, the low and high numbers are represented as string.

 Construct char array from lenLow to lenHigh and increase count when s is between low and high. Add the stro pairs from outside to inside until left > right.
 */
public class Strobogrammatic_Number_III {
    char[][] pair={{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    int r=0;
    public int strobogrammaticInRange(String low, String high) {
        for(int i=low.length();i<=high.length();i++)
            dfs(low, high, new char[i], 0, i-1);
        return r;
    }
    public void dfs(String l, String h, char[] c, int s, int e){
        if(s>e){
            String str=new String(c);
            if((str.length() == l.length() && str.compareTo(l)<0) || (str.length()==h.length() && str.compareTo(h)>0))
                return;
            r++;
            return;
        }
        for(char[] p : pair){
            c[s]=p[0];
            c[e]=p[1];
            if(c.length!=1 && c[0]=='0')
                continue;
            if(s<e || s==e && p[0]==p[1])
                dfs(l, h, c, s+1, e-1);
        }
    }

}
