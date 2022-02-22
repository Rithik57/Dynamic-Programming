import java.util.*;

public class solution{
    public static void main(String[] args) {
        System.out.println(eggdrop(10,2));
    }
    static int[][] dp = new int[11][3];
    public static int eggdrop(int egg,int floor){
        if(egg==1)return floor;
        if(floor==0 || floor==1)return floor;
        if(dp[egg][floor]!=0)return dp[egg][floor];
        int min = Integer.MAX_VALUE;
        for(int k=1;k<=floor;k++){
            int temp = 1 + Math.max(eggdrop(egg-1,k-1),eggdrop(egg,floor-k));
            min = Math.min(temp,min);
        }
        dp[egg][floor] = min;
        return min;
    }
}
