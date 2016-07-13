package indeed.indeed3;

import java.util.*;

public class Main1 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String string_a = in.nextLine(), string_b = in.nextLine();

        int[] count_minus = new int[10];
        int count_plus = 0;
        boolean flag = false;
        boolean can_or_not = true;
        HashSet<Integer> minus = new HashSet<>();
        HashSet<Integer> plus = new HashSet<>();
        for(int i = 0; i < string_a.length(); i++)
        {
            int t = Math.abs(string_a.charAt(i) - string_b.charAt(i));
            count_minus[i] = t;
            if(t != 0)
                minus.add(t);
        }
        if(minus.size() != 0)
        {
            if(minus.size()!= 1)
                can_or_not = false;
            else
            {
                for(int i = 0; i < string_a.length(); i++)
                {
                    if(count_minus[i] != 0)
                    {
                        int t = string_a.charAt(i) + string_b.charAt(i);
                        plus.add(t);
                    }
                }
                if(plus.size() != 1)
                    can_or_not = false;
            }
        }
        String reslut = new String();
        if(can_or_not)
            reslut = "Possible";
        else
            reslut = "Impossible";
        System.out.println(reslut);
    }

}