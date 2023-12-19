/*
Given an AVL tree and N values to be inserted in the tree. Write a function to insert elements into the given AVL tree.

Note:
The tree will be checked after each insertion. 
If it violates the properties of balanced BST, an error message will be printed followed by the inorder traversal of the tree at that moment.
If instead all insertions are successful, inorder traversal of the tree will be printed.

Example 1:

Input:
N = 3
Values to be inserted = {5,1,4} 
Output:
1 4 5
Explanation:
Value to be inserted = 5
    5
Value to be inserted = 1
    5
   /
  1
Value to be inserted = 4
  5                     4
 /    LR rotation        /  \
1    ----------->       1   5
 \
 4
Therefore the inorder of the final tree will be 1, 4, 5.
Example 2:

Input:
N = 7
Values to be inserted = {21,26,30,9,4,14,28} 
Output:
4 9 14 21 26 28 30
Explanation:
Value to be inserted = 21
    21
Value to be inserted = 26
    21
     \
     26
Value to be inserted = 30
  21                        26
   \      LL rotation         /  \
   26    ----------->       21  30
    \
     30
Value to be inserted = 9
    26
   /  \
  21  30
 /
9
Value to be inserted = 4
      26                          26
     /  \                          /  \
    21  30                      9   30
   /          RR rotation        /  \
  9          ----------->       4  21
 /
4
Value to be inserted = 14
      26                          21
     /  \                          /  \
    9   30                      9   26
   / \          LR rotation      /  \    \
  4  21        ----------->    4  14  30
     /
    14
Value to be inserted = 28
      21                          21
     /  \                          /  \
    9   26                      9   28
   / \    \     RL rotation       / \    / \
  4  14   30   ----------->   4  14 26 30
          /
         28
Therefore the inorder of the final tree will be 4, 9, 14, 21, 26, 28, 30.
*/

class AVLTreeValueInsertion
{
    public  Node insertToAVL(Node node,int data)
    {
        if(node == null){
            return new Node(data);
        }
        if(data < node.data){
            node.left =insertToAVL(node.left, data);
        }
        else if(data > node.data){
            node.right =insertToAVL(node.right, data);
        }
        else return node;
        
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        int bf = getBalance(node);
        if(bf > 1 && data < node.left.data) return rightRotate(node);
        if(bf < -1 && data > node.right.data) return leftRotate(node);
        if(bf>1 && data>node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(bf<-1 && data<node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        
        y.height = Math.max(height(y.left), height(y.right))+1;
        x.height = Math.max(height(x.left), height(x.right))+1;
        return x;
    }
    
    private Node leftRotate(Node x){
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;
        return y;
    }
    
    private int getBalance(Node node){
        if(node == null) return 0;
        return height(node.left)-height(node.right);
    }
    
    private int height(Node node){
        if(node==null) return 0;
        return node.height;
    }
} 
