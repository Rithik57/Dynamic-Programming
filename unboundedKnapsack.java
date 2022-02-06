public class solution{
    public static void main(String[] args) {
        int[] values = new int[]{1,3};
        int[] weights = new int[]{1,5};
        System.out.println(UBknapsackDP(values,weights,2,10));
    }
    public static int UBknapsack(int[] values,int[] weights,int n,int cap){
        if(cap==0)return 0;
        if(n==0)return 0;
        if(weights[n-1] <= cap){
            return Math.max(values[n-1] + UBknapsack(values,weights,n,cap-weights[n-1]),UBknapsack(values,weights,n-1,cap));
        }
        return UBknapsack(values,weights,n-1,cap);
    }
    public static int UBknapsackDP(int[] values,int[] weights,int n,int cap){
        int[][] dp = new int[n+1][cap+1];
        //n by cap
        for(int i=1;i<n+1;i++){ // n by i
            for(int j=1;j<cap+1;j++){ // cap by j
                if(weights[i-1] <= j){
                    dp[i][j] = Math.max(values[i-1] + dp[i][j-weights[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[n][cap];
    }
}
