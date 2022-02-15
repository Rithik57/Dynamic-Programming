public class solution{
    public static void main(String[] args) {
        String one = "AABEBCDD";
        System.out.println(LRSDP(one,one,one.length(),one.length()));
    }
    /*
    similar to LCS
    the first and second strings are identical but the subsequence length is only increased when the characters are matched
    at unequal indices which indicate that the character was repeating
     */
    public static int LRS(String first,String second,int n,int m){
        if(n==0 || m==0)return 0;
        if(first.charAt(n-1)==second.charAt(m-1) && n!=m){
            return 1 + LRS(first,second,n-1,m-1);
        }
        return Math.max(LRS(first,second,n-1,m),LRS(first,second,n,m-1));
    }
    public static int LRSDP(String first,String second,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(first.charAt(i-1)==second.charAt(j-1) && i!=j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
