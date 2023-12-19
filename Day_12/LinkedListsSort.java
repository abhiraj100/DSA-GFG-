/*
Given two linked lists sorted in increasing order, create a new linked list representing the intersection of the two linked lists. The new linked list should be made with without changing the original lists.

Note: The elements of the linked list are not necessarily distinct.

Example 1:

Input:
LinkedList1 = 1->2->3->4->6
LinkedList2 = 2->4->6->8
Output: 2 4 6
*/

class LinkedListsSort
{
   public static Node findIntersection(Node head1, Node head2)
    {
         Node dummy = new Node(0); 
        Node intersectionList = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                intersectionList.next = new Node(head1.data);
                intersectionList = intersectionList.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return dummy.next; 
    }
}
