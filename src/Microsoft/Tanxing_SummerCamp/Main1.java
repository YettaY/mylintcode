//import java.util.*;
//public class Main
//{
//    public static boolean is_number(String x)
//    {
//        if( x.charAt(0) >= '0' && x.charAt(0) <= '9')
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//
//    }
//
//    public static boolean opp(int type, int a, int b)
//    {
//        if(type == 1)
//        {
//            return a < b;
//        }
//        else
//        {
//            return a <= b;
//        }
//    }
//
//    static class condition
//    {
//        String a;
//        String b;
//        int op;
//        public condition(String x1, String x2, int x3)
//        {
//            a = x1;
//            b = x2;
//            op = x3;
//        }
//        public boolean verity(HashMap<String, Integer> map)
//        {
//            int x1, x2;
//            if(is_number(a))
//            {
//                x1 = Integer.valueOf(a);
//            }
//            else
//            {
//                x1 = map.get(a);
//            }
//            if(is_number(b))
//            {
//                x2 = Integer.valueOf(b);
//            }
//            else
//            {
//                x2 = map.get(b);
//            }
//
//            return opp(op, x1,x2);
//        }
//    }
//
//
//
//
//
//    public static void set_add(HashSet<String> set, String c)
//    {
//        if( c.charAt(0) >= '0' && c.charAt(0) <= '9')
//            ;
//        else
//            set.add(c);
//
//    }
//    public static String findnum(String s, int j)
//    {
//        String temp = new String();
//        for(int i = j; i < s.length(); i++)
//        {
//
//            char c = s.charAt(i);
//            if(c != '!' && c != '<' && c != '=')
//            {
//                if(c >= 'A' && c <= 'Z')
//                {
//                    temp += c;
//                    break;
//                }
//                if(c >= '0' && c <= '9')
//                {
//                    temp += c;
//                }
//
//            }
//            else
//                break;
//        }
//        return temp;
//    }
//    public static void main(String[] args)
//    {
//        Scanner in = new Scanner(System.in);
//
//        int line_num = in.nextInt();
//        in.nextLine();
//        String[] input = new String[line_num];
//        ArrayList<condition> con = new ArrayList<>();
//        HashSet<String> set = new HashSet<>();
//        for(int i = 0; i < line_num; i++)
//        {
//            input[i] = in.nextLine();
//            input[i] += '!';
//            String last = findnum( input[i], 0);
//            for(Integer j = last.length(); j < input[i].length(); j++)
//            {
//                char c = input[i].charAt(j);
//                if(c != '!')
//                {
//                    if(c == '<')
//                    {
//                        int op_type = 1;
//                        if(input[i].charAt(j + 1) == '=')
//                            op_type =2;
//                        String d = findnum(input[i],j + op_type);
//                        con.add(new condition(last, d, op_type));
//                        set_add(set, last);
//                        set_add(set, d);
//                        j += (op_type + d.length()) - 1;
//                    }
//                    else
//                    {
//                        last = findnum(input[i],j);
//                        j += last.length() - 1;
//                    }
//                }
//            }
//        }
//
//        int test_num = in.nextInt();
//        in.nextLine();
//        for(int i = 0; i < test_num; i++)
//        {
//            HashMap<String, Integer> map = new HashMap<>();
//            for(int j = 0; j < set.size(); j++)
//            {
//                String input_test = in.nextLine();
//                String[] ss = input_test.split(" ");
//                map.put(ss[0], Integer.parseInt(ss[1]));
//            }
//            boolean flag = true;
//            for(condition co:con)
//            {
//                if(co.verity(map) == false)
//                {
//                    flag = false;
//                    break;
//                }
//            }
//            System.out.println(flag == true ? "Yes" : "No");
//        }
//
//
//
//    }
//}