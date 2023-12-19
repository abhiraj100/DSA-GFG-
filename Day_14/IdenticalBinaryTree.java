/*
Given two binary trees, the task is to find if both of them are identical or not.
Note: You need to return true or false, the printing is done by the driver code.

Example 1:

Input:
     1          1
   /   \      /   \
  2     3    2     3
Output: 
Yes
*/
class IdenticalBinaryTree
{
	boolean isIdentical(Node root1, Node root2)
	{
	       if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.data == root2.data) && 
               isIdentical(root1.left, root2.left) && 
               isIdentical(root1.right, root2.right);
	}
	
}
