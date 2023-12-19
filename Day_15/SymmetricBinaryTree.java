/*
Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.

Example 1:

Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: 
True
*/

class SymmetricBinaryTree {
    public static boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;
        
        return (node1.data == node2.data)
            && isMirror(node1.left, node2.right)
            && isMirror(node1.right, node2.left);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        
        return isMirror(root.left, root.right);
    }
}
