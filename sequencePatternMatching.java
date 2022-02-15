import java.util.*;

public class solution{
    public static void main(String[] args) {
        System.out.println(pattern("AXY","ADXCPY",3,6));
    }
    public static boolean pattern(String first,String second,int n,int m){
        if(n==0)return true;
        if(m==0)return false;
        if(first.charAt(n-1)==second.charAt(m-1)){
            return pattern(first,second,n-1,m-1);
        }
        return pattern(first,second,n,m-1);
    }
}
