public class solution{
    public static void main(String[] args) {
        int[] length = new int[]{1,2,3,4,5,6,7,8};
        int[] value = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodCuttingDP(length,value,length.length,length.length));
    }
    public static int rodCutting(int[] length,int[] value,int n,int cap){
        if(n==0)return 0;
        if(cap==0)return 0;
        if(length[n-1] <= cap){
            return Math.max(value[n-1] + rodCutting(length,value,n,cap-length[n-1]),rodCutting(length,value,n-1,cap));
        }
        return rodCutting(length,value,n-1,cap);
    }
    public static int rodCuttingDP(int[] length,int[] value,int n,int cap){
        int[][] dp = new int[n+1][cap+1];
        for(int i=1;i<n+1;i++){ // n by i
            for(int j=1;j<cap+1;j++){ // j by cap
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(value[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][cap];
    }
}
