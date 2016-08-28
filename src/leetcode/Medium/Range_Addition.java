package leetcode.Medium;

/**
 * Created by yanglu on 16/8/8.
 * Assume you have an array of length n initialized with all 0's and are given k update operations.

 Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

 Return the modified array after all k operations were executed.

 Example:

 Given:

 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]
 Explanation:

 Initial state:
 [ 0, 0, 0, 0, 0 ]

 After applying operation [1, 3, 2]:
 [ 0, 2, 2, 2, 0 ]

 After applying operation [2, 4, 3]:
 [ 0, 2, 5, 5, 3 ]

 After applying operation [0, 2, -2]:
 [-2, 0, 3, 5, 3 ]


 segment [i,j] is made of two parts [0,i-1] and [0, j]
 so [i,j] increase 2 is same as [0,j] increase 2 and [0,i-1] increase -2. so you only need to update value at nums[j] with inc and nums[i-1] -inc. initially nums[i] is defined as all elements [0,i] increases inc

 then think from length-1 to 0 backward. The last spot nums[length-1] does not need any modification.
 nums[length-2] value should be updated as nums[length-2] + nums[length-1] as the latter covers the former. but the former does not influence what is after it. so every spot should be updated as + the accumulate sum from the end.
 */
public class Range_Addition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int[] update : updates) {
            nums[update[1]] += update[2];
            if (update[0] > 0)
                nums[update[0] - 1] -= update[2];
        }
        for (int i = length - 2; i >= 0; i--)
            nums[i] += nums[i + 1];

        return nums;
    }
}
