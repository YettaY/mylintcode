package leetcode.Medium;

import java.util.Random;

/**
 * Created by Administrator on 2016/9/26.
 */
public class Random_Pick_Index {
    public class Solution {
        int[] n;
        Random r;
        public Solution(int[] nums) {
            n=nums;
            r=new Random();
        }

        public int pick(int target) {
            int ans=-1, c=0;
            for(int i=0;i<n.length;i++){
                if(n[i]==target){
                    if(r.nextInt(++c)==0)
                        ans=i;
                }
            }
            return ans;
        }
    }
}
