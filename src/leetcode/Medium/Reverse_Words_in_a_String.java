package leetcode.Medium;


import java.util.*;

/**
 * Created by yanglu on 16/7/24.
 */
public class Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
        if (s == null) return null;

        //char[] a = s.toCharArray();
        int n = s.length();

        // step 1. reverse the whole string
        s=reverse(s.toCharArray(), 0, n - 1);
        // step 2. reverse each word
        s=reverseWords(s.toCharArray(), n);
        // step 3. clean up spaces
        return cleanSpaces(s.toCharArray(), n);
    }

    static String reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
        return String.valueOf(a);
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private static String reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
        return String.valueOf(a);
    }
    public static void main(String[] args){
        String s="   a   b ";
        System.out.println("\""+reverseWords(s)+"\"");
    }
}
