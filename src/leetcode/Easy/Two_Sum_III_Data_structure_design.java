package leetcode.Easy;

import java.util.*;

/**
 * Created by Administrator on 2016/9/7.
 */
public class Two_Sum_III_Data_structure_design {
    class TwoSum {
        List<Integer> list=new ArrayList<Integer>();
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        // Add the number to an internal data structure.
        public void add(int number) {
            list.add(number);
            if(map.containsKey(number))
                map.put(number, map.get(number)+1);
            else
                map.put(number, 1);
        }

        // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int value) {
            for(int i=0;i<list.size();i++){
                int n1=list.get(i), n2=value-n1;
                if((n1==n2 && map.get(n1)>1) || (n1!=n2 && map.containsKey(n2)))
                    return true;
            }
            return false;
        }
    }
}
