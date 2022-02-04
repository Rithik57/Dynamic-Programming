import java.util.*;

public class solution{
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3};
        System.out.println(countSubsetsDP(arr,arr.length,(sum+difference)/2));
    }
    static int sum = 7;
    static int difference = 1;
    public static int countSubsets(int[] arr,int n,int current){
        if(current==0)return 1;
        if(n==0)return 0;
        if(arr[n-1]<= current){
            return countSubsets(arr,n-1,current-arr[n-1])+countSubsets(arr,n-1,current);
        }
        return countSubsets(arr,n-1,current);
    }
    public static int countSubsetsDP(int[] arr,int n,int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n+1;i++){ // n by i
            for(int j=1;j<sum+1;j++){ // current by j
                if(arr[i-1] <=  j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
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
        return dp[n][sum];
    }
}
