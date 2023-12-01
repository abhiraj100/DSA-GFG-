class GfG {
    // Helper function to check if two trees are mirror images of each other
    public static boolean isMirror(Node node1, Node node2) {
        // If both nodes are null, they are mirror images
        if (node1 == null && node2 == null)
            return true;

        // If only one of the nodes is null, they can't be mirror images
        if (node1 == null || node2 == null)
            return false;

        // Check if the current nodes' values are equal and
        // their subtrees are mirror images of each other
        return (node1.data == node2.data)
            && isMirror(node1.left, node2.right)
            && isMirror(node1.right, node2.left);
    }

    // Main function to check whether the tree is symmetric or not
    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        // Check if the left and right subtrees are mirror images
        return isMirror(root.left, root.right);
    }
}
