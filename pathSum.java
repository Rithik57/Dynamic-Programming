import java.util.*;
import java.util.Stack;

public class solution{
    public static void main(String[] args) {

    }
    static int res = Integer.MIN_VALUE;
    static int findMaxSum(Node node)
    {
        solve(node);
        return max;
    }
    static int max = Integer.MIN_VALUE;
    static int solve(Node root){
        if(root==null)return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        int temp = Math.max(root.data + Math.max(left,right),root.data);
        int ans = Math.max(temp,left + right + root.data);
        max = Math.max(ans,max);
        return temp;
    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
