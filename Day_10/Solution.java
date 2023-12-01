class treeInfo {
    Node head;
    Node tail;

    treeInfo(Node h, Node t) {
        head = h;
        tail = t;
    }
}

class Solution { 
    treeInfo inOrder(Node root) {
        if (root == null) {
            return new treeInfo(null, null);
        }

        treeInfo left = inOrder(root.left);

        Node newNode = new Node(root.data);

        if (left.tail != null)
            left.tail.right = newNode;

        newNode.left = left.tail;

        treeInfo right = inOrder(root.right);
        newNode.right = right.head;

        if (right.head != null)
            right.head.left = newNode;

        Node outputHead = left.head;
        Node outputTail = right.tail;
        if (left.head == null) {
            outputHead = newNode;
        }

        if (right.tail == null) {
            outputTail = newNode;
        }

        return new treeInfo(outputHead, outputTail);
    }

    // Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root) {
        treeInfo output = inOrder(root);

        output.head.left = output.tail;
        output.tail.right = output.head;

        return output.head;
    }
}
