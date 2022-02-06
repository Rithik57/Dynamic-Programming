class Solution {
    /*
    this is the same as dividing the array into two halves whose difference is equal to a
    certain value
    to reach the value the two equations can be used to obtained the required sum of one of the
    subsets as (sum+difference)/2
    */
    static int findTargetSumWays(int[] arr , int n, int current) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        if((sum+current)%2!=0)return 0;
        return targetSumDP(arr,n,(sum+current)/2);
    }
    public static int targetSumDP(int[] arr,int n,int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
