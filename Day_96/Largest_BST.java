/*
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).
*/

class Solution {
    
    static class Info {
        public int maxi;
        public int mini;
        public boolean isBST;
        public int size;
        
        public Info(int maxi, int mini, boolean isBST, int size) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBST = isBST;
            this.size = size;
        }
        
        public Info() {
            this.maxi = Integer.MIN_VALUE;
            this.mini = Integer.MAX_VALUE;
            this.isBST = true;
            this.size = 0;
        }
    }
    
    private static Info solve(Node root, int[] ans) {
        if(root == null) {
            return new Info();
        }
        
        Info left = solve(root.left, ans);
        Info right = solve(root.right, ans);
        
        int mini = Math.min(root.data, Math.min(left.mini, right.mini));
        int maxi = Math.max(root.data, Math.max(left.maxi, right.maxi));
        
        boolean isBST = (left.isBST && right.isBST && root.data > left.maxi && root.data < right.mini);
        
        int size = isBST ? left.size + right.size + 1 : 0;
        
        ans[0] = Math.max(ans[0], size);
        
        return new Info(maxi, mini, isBST, size);
    }
    
    static int largestBst(Node root) {
        if (root == null) return 0;
        
        int[] maxSize = new int[1];
        solve(root, maxSize);
        return maxSize[0];
    }
}