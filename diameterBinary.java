class Solution {
    // Function to return the diameter of a Binary Tree.
  /*
  temp stores the answer that will be sent to the calling node
  ans calculates the answer for this node
  */
    int res = Integer.MIN_VALUE;
    int diameter(Node root) {
        solve(root);
        return res;
    }
    int solve(Node root) {
        if(root==null)return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        int temp = 1 + Math.max(left,right);
        int ans = Math.max(temp,1+left+right);
        res = Math.max(ans,res);
        return temp;
    }
}
