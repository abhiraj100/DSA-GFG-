/*
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)
*/

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        Node head1=head;
        int length=0;
        while(head1!=null){
            length++;
            head1=head1.next;
        }
        Node current=head;
        int len=length;
        for (int i = 0; i < len; i++) {
            current = head;
            for (int j = 0; j < len - i - 1; j++) {
                if (current.data > current.next.data) {
                    int swap = current.data;
                    current.data = current.next.data;
                    current.next.data = swap;
                }
                current = current.next;
            }
        }
        return head;
    }
}

