import java.util.*;

public class solution{
    public static void main(String[] args) {
        String s = "intention";
        String t = "execution";
        System.out.println(editDistance(s,t,s.length(),t.length()));
    }
    /*
    base case : while iterating the strings if one of the indices reaches 0 then that means the length of the other
    string that remains is returned
    if character matches no operation required
    if doesnt match then 1 operation is performed : insert,delete or replace and the indices move forward as required
    the minimum of these results is taken
    if replaced then both characters now match and both indices move forward
    if inserted or deleted then one of the indices moves
     */
    public static int recursive(String s,String t,int i,int j){
        if(i==0)return j;
        if(j==0)return i;
        if(s.charAt(i-1)==t.charAt(j-1)){
            return recursive(s,t,i-1,j-1);
        }
        return 1 + Math.min(recursive(s,t,i-1,j-1),Math.min(recursive(s,t,i-1,j),recursive(s,t,i,j-1)));
    }
    public static int editDistance(String s,String t,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[0][i] = i;
        }
        for(int j=0;j<m+1;j++){
            dp[j][0] = j;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}
