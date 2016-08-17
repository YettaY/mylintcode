package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 * Design a Phone Directory which supports the following operations:

 get: Provide a number which is not assigned to anyone.
 check: Check if a number is available or not.
 release: Recycle or release a number.
 Example:

 // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 PhoneDirectory directory = new PhoneDirectory(3);

 // It can return any available phone number. Here we assume it returns 0.
 directory.get();

 // Assume it returns 1.
 directory.get();

 // The number 2 is available, so return true.
 directory.check(2);

 // It returns 2, the only number that is left.
 directory.get();

 // The number 2 is no longer available, so return false.
 directory.check(2);

 // Release number 2 back to the pool.
 directory.release(2);

 // Number 2 is available again, return true.
 directory.check(2);

 java.util.BitSet可以按位存储。
 计算机中一个字节（byte）占8位（bit），我们java中数据至少按字节存储的，
 比如一个int占4个字节。
 如果遇到大的数据量，这样必然会需要很大存储空间和内存。
 如何减少数据占用存储空间和内存可以用算法解决。
 java.util.BitSet就提供了这样的算法。
 比如有一堆数字，需要存储，source=[3,5,6,9]
 用int就需要4*4个字节。
 java.util.BitSet可以存true/false。
 如果用java.util.BitSet，则会少很多，其原理是：
 1，先找出数据中最大值maxvalue=9
 2，声明一个BitSet bs,它的size是maxvalue+1=10
 3，遍历数据source，bs[source[i]]设置成true.
 最后的值是：
 (0为false;1为true)
 bs [0,0,0,1,0,1,1,0,0,1]
 3,   5,6,       9
 这样一个本来要int型需要占4字节共32位的数字现在只用了1位！
 比例32:1
 这样就省下了很大空间。

 */
public class Design_Phone_Directory {
    class PhoneDirectory {
        private boolean[] numbers;
        private Deque<Integer> q;

        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            numbers = new boolean[maxNumbers] ;
            Arrays.fill(numbers, true);
            q = new LinkedList<Integer>();

            for(int i = 0; i < maxNumbers; i++)
                q.offer(i);
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if(q.size() == 0)
                return -1;
            int number = q.pollFirst();
            numbers[number] = false;
            return number;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return numbers[number];
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if(!numbers[number]) {
                numbers[number] = true;
                q.offer(number);
            }
        }
    }
/*Solution 2:The idea is to use java's bitset and use smallestFreeIndex/max to keep track of the limit.
    Also, by keeping track of the updated smallestFreeIndex all the time, the run time of get()
    is spared from scanning the entire bitset every time.*/
//    class PhoneDirectory {
//
//        BitSet bitset;
//        int max; // max limit allowed
//        int smallestFreeIndex; // current smallest index of the free bit
//
//        public PhoneDirectory(int maxNumbers) {
//            this.bitset = new BitSet(maxNumbers);
//            this.max = maxNumbers;
//        }
//
//        public int get() {
//            // handle bitset fully allocated
//            if(smallestFreeIndex == max) {
//                return -1;
//            }
//            int num = smallestFreeIndex;
//            bitset.set(smallestFreeIndex);
//            //Only scan for the next free bit, from the previously known smallest free index
//            smallestFreeIndex = bitset.nextClearBit(smallestFreeIndex);
//            return num;
//        }
//
//        public boolean check(int number) {
//            return bitset.get(number) == false;
//        }
//
//        public void release(int number) {
//            //handle release of unallocated ones
//            if(bitset.get(number) == false)
//                return;
//            bitset.clear(number);
//            if(number < smallestFreeIndex) {
//                smallestFreeIndex = number;
//            }
//        }
//    }
}
