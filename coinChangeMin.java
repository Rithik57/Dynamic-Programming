import java.util.*;

public class solution{
    public static void main(String[] args) {
        int[] arr = new int[]{15};
        System.out.println(coinChangeDP(arr,1,4));
    }
    public static int coinChange(int[] arr,int n,int target){
        if(target==0)return 0;
        if(n==0)return Integer.MAX_VALUE-1;
        if(arr[n-1] <= target){
            return Math.min(1+coinChange(arr,n,target-arr[n-1]),coinChange(arr,n-1,target));
        }
        return coinChange(arr,n-1,target);
    }
    public static int coinChangeDP(int[] arr,int n,int target){
        int[][] dp = new int[n+1][target+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        for(int i=1;i<n+1;i++){ // n by i
            for(int j=1;j<target+1;j++){ //target by j
                if(arr[i-1] <= j){
                    dp[i][j] = Math.min(1+dp[i][j - arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][target]==Integer.MAX_VALUE-1)return -1;
        return dp[n][target];
    }
}
