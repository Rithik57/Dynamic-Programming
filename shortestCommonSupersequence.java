class Solution
{
    /*
    supersequence is the string that contains the sequence of both the strings
    shortest common supersequence can be achieved by obtaining the longest common
    subsequence amongst the strings and adding the unique elements in both the strings
    */
    public static int shortestCommonSupersequence(String first,String second,int n,int m)
    {
        int common = LCS(first,second,n,m);
        common += (first.length()-common) + (second.length()-common);
        return common;
    }
    public static int LCS(String first,String second,int n,int m){
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
