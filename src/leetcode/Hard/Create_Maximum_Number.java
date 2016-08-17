package leetcode.Hard;

/**
 * Created by yanglu on 16/8/8.
 * Many of the posts have the same algorithm. In short we can first solve 2 simpler problem

 Create the maximum number of one array
 Create the maximum number of two array using all of their digits.
 For an long and detailed explanation see my blog here.

 The algorithm is O((m+n)^3) in the worst case. It runs in 22 ms.
 */
public class Create_Maximum_Number {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] r=new int[k];
        for(int i=Math.max(0,k-nums2.length);i<=k&&i<=nums1.length;i++)
        {
            int[] x=merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if(bigger(x,0,r,0))
                r=x;
        }
        return r;
    }
    public static int[] merge(int[] n1, int[] n2, int k)
    {
        int[] r=new int[k];
        for(int i=0,j=0,x=0;x<k;x++)
        {
            r[x]=bigger(n1,i, n2,j)?n1[i++]:n2[j++];
        }
        return r;
    }
    public static boolean bigger(int[] n1,int i,int[] n2,int j)
    {
        while(i<n1.length && j<n2.length && n1[i]==n2[j])
        {
            i++;j++;
        }
        return j==n2.length || (i<n1.length && n1[i]>n2[j]);
    }
    public static int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
