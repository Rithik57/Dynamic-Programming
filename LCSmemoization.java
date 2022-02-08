public class solution{
    public static void main(String[] args) {
        String one = "AGGTAB";
        String two = "GXTXAYB";
        System.out.println(LCS(one,two,one.length(),two.length()));
    }
    static int[][] dp = new int[7][8];
    public static int LCS(String first,String second,int n,int m){
        //smallest valid input
        if(n==0 || m==0)return 0;
        if(dp[n][m]!=0)return dp[n][m];
        // in case the last characters of both the strings match
        if(first.charAt(n-1) == second.charAt(m-1)){
            int result =  1 + LCS(first,second,n-1,m-1);
            dp[n][m] = result;
            return result;
        }
        // in case the last characters do not match consider shortening both strings
        int result = Math.max(LCS(first,second,n-1,m),LCS(first,second,n,m-1));
        dp[n][m] = result;
        return result;
    }
}
