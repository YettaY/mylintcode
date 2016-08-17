package leetcode.Medium;

import java.util.Random;

/**
 * Created by yanglu on 16/8/13.
 Time O(N), Space O(N)
 the Algorithm is :
 [0, 1, 2, ... N-1]

 randomly pick one of them and swap to the index 0 position.
 [X, 1, 2, ... N-1]

 then pick one of them form {1: N-1} and swap to index 1 position.
 etc...

 */
public class Shuffle_an_Array {

    //Solution1:O(N)
//    public class Solution {
//        int[] nums;
//        Random r;
//        public Solution(int[] nums) {
//            this.nums=nums;
//            r=new Random();
//        }
//
//        /** Resets the array to its original configuration and return it. */
//        public int[] reset() {
//            return nums;
//        }
//
//        /** Returns a random shuffling of the array. */
//        public int[] shuffle() {
//            if (nums==null)
//                return null;
//            int[] a=nums.clone();
//            for(int j=1;j<a.length;j++){
//                int i=r.nextInt(j+1);
//                int t=a[i];
//                a[i]=a[j];
//                a[j]=t;
//            }
//            return a;
//        }
//    }

    //Solution 2: without copying the original array during each shuffle call
        public class Solution {
        int[] nums;
        int[] a;
        Random r;
        public Solution(int[] nums) {
            this.nums=nums;
            r=new Random();
            a=new int[nums.length];
            for (int i=0;i<nums.length;i++)
                a[i]=nums[i];
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for(int j=1;j<a.length;j++){
                int i=r.nextInt(j+1);
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
            return a;
        }
    }
}
