package leetcode.Easy;

/**
 * Created by yanglu on 16/7/27.
 */
public class Reverse_String {
    public String reverseString(String s) {
        if (s == null || s.length() < 2)
            return s;
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            c[i] = (char) (c[i] ^ c[j]);
            c[j] = (char) (c[i] ^ c[j]);
            c[i] = (char) (c[i] ^ c[j]);
            i++;
            j--;
        }
        return new String(c);
    }
}