public class solution{
    public static void main(String[] args) {
        String one = "ABCDGH";
        String two = "AEDFHR";
        StringBuilder builder = new StringBuilder(printLCSDP(one,two,one.length(),two.length()));
        System.out.println(builder.reverse().toString());
    }
    public static String printLCS(String first,String second,int n,int m){
        if(n==0 || m==0)return "";
        if(first.charAt(n-1)==second.charAt(m-1)){
            return first.charAt(n-1) + printLCS(first,second,n-1,m-1);
        }
        String result1 = printLCS(first,second,n-1,m);
        String result2 = printLCS(first,second,n,m-1);
        if(result1.length() >= result2.length()){
            return result1;
        }else{
            return result2;
        }
    }
    public static String printLCSDP(String first,String second,int n,int m){
        String[][] dp = new String[n+1][m+1];
        Arrays.fill(dp[0],"");
        for(int i=0;i<n+1;i++){
            dp[i][0] = "";
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(first.charAt(i-1)==second.charAt(j-1)){
                    dp[i][j] = first.charAt(i-1) + dp[i-1][j-1];
                }else{
                    if(dp[i-1][j].length() >= dp[i][j-1].length()){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
