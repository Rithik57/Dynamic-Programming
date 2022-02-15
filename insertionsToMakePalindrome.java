import java.util.*;

public class solution{
    public static void main(String[] args) {
        System.out.println(countMin("aa"));
    }
    /*
    the LCS between the string and its reverse gives us the elements in the palindrome that are in the correct place
    the difference in the lengths of the original string and this LCS is the required number of insertions
     */
    static int countMin(String str)
    {
        StringBuilder builder = new StringBuilder(str);
        String rev = builder.reverse().toString();
        return str.length() - LCSDP(str,rev,str.length(),rev.length());
    }
    public static int LCS(String first,String second,int n,int m){
        if(n==0 || m==0)return 0;
        if(first.charAt(n-1) == second.charAt(m-1)){
            return 1+LCS(first,second,n-1,m-1);
        }
        return Math.max(LCS(first,second,n,m-1),LCS(first,second,n-1,m));
    }
    public static int LCSDP(String first,String second,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(first.charAt(i-1)==second.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
