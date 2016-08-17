package leetcode.Hard;
import java.util.*;
/**
 * Created by yanglu on 16/8/11.
 */
public class Insert_Delete_GetRandom_O1_Duplicates_allowed {
    public class RandomizedCollection {

        ArrayList<Integer> nums;
        HashMap<Integer, HashSet<Integer>> locs;
        java.util.Random rand = new java.util.Random();
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, HashSet<Integer>>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if ( ! contain )
                locs.put( val, new LinkedHashSet<Integer>() );
            locs.get(val).add(nums.size());
            nums.add(val);
            return ! contain ;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!locs.containsKey(val))
                return false;

            int id=locs.get(val).iterator().next();
            locs.get(val).remove(id);

            if (id < nums.size() - 1 ) {
                int lastone = nums.get(nums.size() - 1 );
                nums.set( id , lastone );
                locs.get(lastone).remove(nums.size() - 1);
                locs.get(lastone).add(id);
            }
            nums.remove(nums.size() - 1);
            if (locs.get(val).isEmpty())
                locs.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get( rand.nextInt(nums.size()) );
        }
    }
}
