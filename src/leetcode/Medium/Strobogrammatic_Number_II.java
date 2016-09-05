package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/7.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,
 Given n = 2, return ["11","69","88","96"].
 */
public class Strobogrammatic_Number_II {
    char[][] pair={{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public List<String> findStrobogrammatic(int n) {
        List<String> ans=new ArrayList<>();
        helper(ans,new char[n], 0,n-1);
        return ans;

    }

    private void helper(List<String> ans, char[] a, int l, int r) {
        if(l>r){
            ans.add(new String(a));
            return;
        }
        for(char[] p:pair){
            a[l]=p[0];
            a[r]=p[1];
            if(a.length>1 && a[0]=='0')
                continue;
            if(l<r || l==r && p[0]==p[1]) //l<=r, n=1时，返回0, 1, 9, 8, 6
                helper(ans, a, l+1, r-1);
        }
    }

}
