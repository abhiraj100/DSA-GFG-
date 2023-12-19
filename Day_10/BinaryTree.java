/*
Given a Binary Tree of N edges. The task is to convert this to a Circular Doubly Linked List (CDLL) in-place. The left and right pointers in nodes are to be used as previous and next pointers respectively in CDLL. The order of nodes in CDLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the CDLL.

Example 1:

Input:
      1
    /   \
   3     2
Output:
3 1 2 
2 1 3
*/

class treeInfo {
    Node head;
    Node tail;

    treeInfo(Node h, Node t) {
        head = h;
        tail = t;
    }
}

class BinaryTree { 
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

    Node bTreeToClist(Node root) {
        treeInfo output = inOrder(root);

        output.head.left = output.tail;
        output.tail.right = output.head;

        return output.head;
    }
}
