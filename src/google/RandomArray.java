package google;
import java.util.*;
/**
 * 大概就是一个数组
 1,4,2,6.....
 每次调用一个函数，按照数组里面的数字的大小，返回相应的Index。
 比如， 上面的例子就是
 1/13 的概率返回0,
 4/13的概率返回1.
 说了两个办法，一个累加起来， 然后用一个随即数，看看在哪个范围里面。另一个先加好，然后Binary search，让写了第二个
 */
// O(nums.length) space, O(logn) time
class MyRNG2 extends Random{
    int[] probs;
    Random r = new Random();
    public MyRNG2(int[] nums) {
        probs = new int[nums.length];
        probs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            probs[i] = probs[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(probs));
    }

    @Override
    public int nextInt() {
        int target = r.nextInt(probs[probs.length - 1] + 1);
        return search(probs, target);
    }

    private int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end + 1;
    }
}

// O(n) space, O(1) time
class MyRNG extends Random{
    int[] probs;
    Random r = new Random();
    public MyRNG(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        probs = new int[sum];
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (count++ < nums[i]) {
                probs[++index] = i;
            }
        }
        System.out.println(Arrays.toString(probs));
    }

    @Override
    public int nextInt() {
        int index = r.nextInt(probs.length);
        return probs[index];
    }
}
public class RandomArray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 6};
        MyRNG r0 = new MyRNG(nums); //
        MyRNG2 r = new MyRNG2(nums);
        System.out.println(r.nextInt());

    }
}
