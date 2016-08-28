package leetcode.Hard;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

 All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

 Example 1:
 str = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.
 Example 2:
 str = "aaabc", k = 3

 Answer: ""

 It is not possible to rearrange the string.
 Example 3:
 str = "aaadbbcc", k = 2

 Answer: "abacabcd"

 Another possible answer is: "abcabcda"

 The same letters are at least distance 2 from each other.


 The greedy algorithm is that in each step, select the char with highest remaining count if possible (if it is not in the waiting queue). PQ is used to achieve the greedy.
 A regular queue waitQueue is used to "freeze" previous appeared char in the period of k.

 In each iteration, we need to add current char to the waitQueue and also release the char at front of the queue,
 put back to maxHeap. The "impossible" case happens when the maxHeap is empty but there is still some char in the waitQueue.
 本题的思路是基于贪心的, 先统计每个字符的数量, 为了让字符排列更紧凑, 借助一个优先队列先排列个数大的字符

 1. 如果剩余的字符的数量大于k, 那么就需要在接下来排列k个不同的字符, 并将这k个不同字符个数都-1, 如果在排这k个不同字符的时候发现并没有k个不同字符, 说明是无法得到答案的.

 2. 如果剩余的字符数量不到k, 那么就在接下排列剩余个数的不同字符. 方法和上面一样.

 在优先队列中存储以(数量+字符)的对, 以k为区间大小排列k个从数量高到低的字符, 然后再重复此过程, 这种贪心的策略可以保证让数量大的最优先排列, 并且使其间隔最小的距离, 否则到后来可能没有足够的空间.

O(nlogn)
 */
public class Rearrange_String_k_Distance_Apart {
    //Solution 1:
    public String rearrangeString1(String str, int k) {

        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == str.length() ? rearranged.toString() : "";




    }//Solution 2:
    /*Every time we want to find the best candidate: which is the character with the largest remaining count. Thus we will be having two arrays.
    One count array to store the remaining count of every character. Another array to keep track of the most left position that one character can appear.
    We will iterated through these two array to find the best candidate for every position. Since the array is fixed size, it will take constant time to do this.
    After we find the candidate, we update two arrays.
    Since the array is fixed size(26), it will take constant time to find max*/
    public static String rearrangeString2(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for(int i=0;i<length;i++){
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0;index<length;index++){
            int candidatePos = findValidMax(count, valid, index);
            if( candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index+k;
            sb.append((char)('a'+candidatePos));
        }
        return sb.toString();
    }

    private static int findValidMax(int[] count, int[] valid, int index){
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for(int i=0;i<count.length;i++){
            if(count[i]>0 && count[i]>max && index>=valid[i]){
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
    public static void main(String[] args){
        System.out.println(rearrangeString2("aabbcc",3));
    }
}
