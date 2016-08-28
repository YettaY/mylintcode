package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 *
 * The follow-up: allowing duplications.
 For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
 Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().

 The idea is to add a set to the hashMap to remember all the locations of a duplicated number.
 */
public class Insert_Delete_GetRandom_O1 {
    class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> locs;
        java.util.Random rand=new java.util.Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if ( locs.containsKey(val))
                return false;
            locs.put( val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if ( !locs.containsKey(val) )
                return false;
            int loc = locs.get(val);
            if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
                int lastone = nums.get(nums.size() - 1 );
                nums.set( loc , lastone );
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get( rand.nextInt(nums.size()) );
        }
    }



    //Follow up: allowing duplication
    // see 381. Insert Delete GetRandom O(1) - Duplicates allowed

}
