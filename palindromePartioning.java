import java.util.*;

public class solution{
    public static void main(String[] args) {
        int result = palindromePartition("abbac",0,4);
        System.out.println(result);
    }
    public static int palindromePartition(String str,int i,int j){
        if(i>=j || isPalindrome(str,i,j))return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = palindromePartition(str,i,k) + palindromePartition(str,k+1,j) + 1;
            min = Math.min(temp,min);
        }
        return min;
    }
    public static boolean isPalindrome(String str,int i,int j){
        while(i < j)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
