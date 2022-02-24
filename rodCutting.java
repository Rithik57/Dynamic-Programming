class Solution{
    public int cutRod(int price[], int n) {
        return solveDP(price,n,n);
    }
    public static int solveDP(int[] price,int W,int n){
        int[][] dp = new int[W+1][n+1];
        for(int i=1;i<W+1;i++){
            for(int j=1;j<n+1;j++){
                if(j<=i){
                    dp[i][j] = Math.max(price[j-1] + dp[i-j][j],dp[i][j-1]);
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[W][n];
    }
}
