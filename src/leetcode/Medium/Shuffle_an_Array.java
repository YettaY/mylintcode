package leetcode.Medium;

import java.util.*;

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

    //Solution1:
    /*Fisher–Yates Shuffle算法思想就是从 原始数组中随机抽取一个新的数字到新数组中。
    *  1. 从还没处理的数组（假如还剩k个）中，随机产生一个[0, k]之间的数字p（假设数组从0开始）；
 2. 从剩下的k个数中把第p个数取出；
 3. 重复步骤2和3直到数字全部取完；
 4. 从步骤3取出的数字序列便是一个打乱了的数列*/
//    public class Solution {
//        int[] nums;
//        List<Integer> list;
//        Random r;
//        public Solution(int[] nums) {
//            this.nums=nums;
//            list=new ArrayList<Integer>();
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
//            int[] a=new int[nums.length];
//            for(int i=0;i<nums.length;i++)
//                list.add(nums[i]);
//            for(int i=0;i<nums.length;i++) {
//                int j=r.nextInt(list.size());
//                a[i]=list.get(j);
//                list.remove(j);
//            }
//            return a;
//        }
//    }

    //Solution 2:
    /*
    * Durstenfeld 在Fisher 等人的基础上对算法进行了改进。
    * 每次从未处理的数据中随机取出一个数字，然后把该数字放在数组的尾部，即数组尾部存放的是已经处理过的数字 。
    * 这是一个原地打乱顺序的算法，算法时间复杂度也从Fisher算法的 O ( n 2 )提升到了 O ( n )。*/
    public class Solution {
        int[] nums;
        int[] a;
        Random r;
        public Solution(int[] nums) {
            this.nums=nums;
            a=new int[nums.length];
            for(int i=0;i<nums.length;i++)
                a[i]=nums[i];
            r=new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if (nums==null)
                return null;
            int n=nums.length-1;
            for(int i=n;i>=0;i--) {
                int j=r.nextInt(i+1);
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
            return a;
        }
    }
    //Solution 3:
    /*Knuth-Durstenfeld Shuffle 是一个in-place算法，原始数据被直接打乱，有些应用中可能需要保留原始数据，因此需要开辟一个新数组来存储打乱后的序列。
    Inside-Out Algorithm 算法的基本思想是设一游标i从前向后扫描原始数据的拷贝，在[0, i]之间随机一个下标j，
    然后用位置j的元素替换掉位置i的数字，再用原始数据位置i的元素替换掉拷贝数据位置j的元素。其作用相当于在拷贝数据中交换i与j位置处的值。*/
//        public class Solution {
//        int[] nums;
//        int[] a;
//        Random r;
//        public Solution(int[] nums) {
//            this.nums=nums;
//            r=new Random();
//            a=new int[nums.length];
//            for (int i=0;i<nums.length;i++)
//                a[i]=nums[i];
//        }
//
//        /** Resets the array to its original configuration and return it. */
//        public int[] reset() {
//            return nums;
//        }
//
//        /** Returns a random shuffling of the array. */
//        public int[] shuffle() {
//            for(int j=1;j<a.length;j++){
//                int i=r.nextInt(j+1);
//                int t=a[i];
//                a[i]=a[j];
//                a[j]=t;
//            }
//            return a;
//        }
//    }
}
