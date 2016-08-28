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
        if (l==r){
            a[l]='0';
            ans.add(new String(a));
            a[l]='1';
            ans.add(new String(a));
            a[l]='8';
            ans.add(new String(a));
            return;
        }
        if (l!=0){
            a[l]='0';a[r]='0';
            helper(ans,a,l+1,r-1);
        }
        a[l]='1';a[r]='1';
        helper(ans,a,l+1,r-1);
        a[l]='6';a[r]='9';
        helper(ans,a,l+1,r-1);
        a[l]='8';a[r]='8';
        helper(ans,a,l+1,r-1);
        a[l]='9';a[r]='6';
        helper(ans,a,l+1,r-1);
    }

}
