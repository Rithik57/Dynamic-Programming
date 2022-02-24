import java.util.*;
import java.util.Stack;

public class solution{
    public static void main(String[] args) {
        System.out.println(knapsackDP(new int[]{10,20,30},new int[]{60,100,120},50,3));
    }
    public static int knapsack(int[] weight,int[] val,int W,int n){
        if(W==0 || n==0)return 0;
        if(weight[n-1] <= W){
            return Math.max(val[n-1] + knapsack(weight,val,W-weight[n-1],n-1),knapsack(weight,val,W,n-1));
        }
        return knapsack(weight,val,W,n-1);
    }
    public static int knapsackDP(int[] weight,int[] val,int W,int n){
        int[][] dp = new int[W+1][n+1];
        for(int i=1;i<W+1;i++){
            for(int j=1;j<n+1;j++){
                if(weight[j-1]<=i){
                    dp[i][j] = Math.max(val[j-1] + dp[i-weight[j-1]][j-1],dp[i][j-1]);
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[W][n];
    }
}
