import org.omg.CORBA.MARSHAL;

/**
 * Created by Administrator on 2016/5/23.
 */
public class s534 {
    public int houseRobber2(int[] nums) {
        if (nums==null|| nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(dfs(nums,0,nums.length-2),dfs(nums,1,nums.length-1));
    }
    public int dfs(int[] n,int s,int e){
        int[] dp=new int[e-s+1];
        dp[0]=n[s];dp[1]=Math.max(n[s],n[s+1]);
        for (int i=2;i<e-s+1;i++){
            dp[i]=Math.max(dp[i-2]+n[i+s],dp[i-1]);
        }
        return dp[e-s];
    }
}
