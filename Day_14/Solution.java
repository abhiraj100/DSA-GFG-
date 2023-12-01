
class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	       if (root1 == null && root2 == null) {
            return true;
        }

        // If one tree is empty and the other is not, they are not identical.
        if (root1 == null || root2 == null) {
            return false;
        }

        // Check if the current nodes are equal and recursively check left and right subtrees.
        return (root1.data == root2.data) && 
               isIdentical(root1.left, root2.left) && 
               isIdentical(root1.right, root2.right);
	}
	
}