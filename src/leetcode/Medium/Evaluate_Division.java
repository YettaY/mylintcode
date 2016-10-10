<<<<<<< HEAD
//package leetcode.Medium;
//import java.util.*;
//
///**
// * Created by Administrator on 2016/9/26.
// */
//public class Evaluate_Division {
//    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
=======
package leetcode.Medium;
import java.util.*;

/**
 * Created by Administrator on 2016/9/26.
 */
public class Evaluate_Division {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //Solution 1:
        //过滤掉没有遇到的字符
        Set<String> word=new HashSet<>();
        for(String[] es:equations){
            word.add(es[0]);
            word.add(es[1]);
        }
        double[] r=new double[queries.length];
        for(int i=0;i<queries.length;i++){
            if(!word.contains(queries[i][0]) || !word.contains(queries[i][1]))
                r[i]=-1.0d;
            else
                r[i]=helper(equations, values, queries[i][0], queries[i][1], new HashSet<Integer>());
        }
        return r;
        //Solution 2:弗洛伊德类似算法构造整张图，queries数据量大的时候比较适用
>>>>>>> 5114cd61b530067d745fa94d8702e82dc79500e5
//        Map<String, Integer> table=new HashMap<>();
//        int len=0;
//        for(String[] es:equations){
//            for (String e:es){
//                if(!table.containsKey(e))
//                    table.put(e, len++);
//            }
//        }
//        double[][] map=new double[len][len];
<<<<<<< HEAD
//
//    }
//}
=======
//        for(int i=0;i<len;i++)
//            for (int j=0;j<len;j++)
//                map[i][j]=(i==j) ? 1.0d: -1.0d;
//
//        for(int i=0;i<equations.length;i++){
//            int row=table.get(equations[i][0]), col=table.get(equations[i][1]);
//            map[row][col]=values[i];
//            map[col][row]=1/values[i];
//        }
//        for(int k=0;k<len;k++){
//            for(int i=0;i<len;i++){
//                for(int j=0;j<len;j++){
//                    if(map[i][k]>=0d && map[k][j]>=0d)
//                        map[i][j]=map[i][k]*map[k][j];
//                }
//            }
//        }
//        double[] r=new double[queries.length];
//        for(int i=0;i<queries.length;i++){
//            Integer row= table.get(queries[i][0]), col=table.get(queries[i][1]);
//            if(row!=null && col!=null)
//                r[i]=map[row][col];
//            else
//                r[i]=-1.0d;
//        }
//        return r;
    }

    private double helper(String[][] equations, double[] values, String a, String b, HashSet<Integer> set) {
        //直接查找
        for(int i=0;i<equations.length;i++){
            if(equations[i][0].equals(a) && equations[i][1].equals(b))
                return values[i];
            if(equations[i][0].equals(b) && equations[i][1].equals(a))
                return 1/values[i];
        }
        //间接查找
        for(int i=0;i<equations.length;i++){
            if(!set.contains(i) && a.equals(equations[i][0])){
                set.add(i);
                double t=values[i] * helper(equations, values, equations[i][1], b, set);
                if(t > 0)
                    return t;
                else
                    set.remove(set.size()-1);
            }
            if(!set.contains(i) && a.equals(equations[i][1])){
                set.add(i);
                double t=helper(equations, values, equations[i][0], b, set)/values[i];
                if(t > 0)
                    return t;
                else
                    set.remove(set.size()-1);
            }
        }
        return -1.0d;
    }
}
>>>>>>> 5114cd61b530067d745fa94d8702e82dc79500e5
