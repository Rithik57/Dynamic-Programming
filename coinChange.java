public class solution{
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(coinChange(arr,3,5));
    }
    public static int coinChange(int[] value,int n,int target){
        if(target==0)return 1;
        if(n==0)return 0;
        if(value[n-1]<=target){
            return coinChange(value,n,target-value[n-1]) + coinChange(value,n-1,target);
        }
        return coinChange(value,n-1,target);
    }
    public static int coinChangeDP(int[] value,int n,int target){
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n+1;i++){ // n by i
            for(int j=1;j<target+1;j++){ // target by j
                if(value[i-1] <= j){
                    dp[i][j] = dp[i][j-value[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
