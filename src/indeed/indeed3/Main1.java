package indeed.indeed3;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] s = input.split(",");
        for(int i=0;i<s.length;i++)
            System.out.println(s[i]);
    }
}
