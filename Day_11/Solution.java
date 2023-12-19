/*
Given a doubly linked list of n elements. Your task is to reverse the doubly linked list in-place.

Example 1:

Input:
LinkedList: 3 <--> 4 <--> 5
Output: 5 4 3
*/

public static Node reverseDLL(Node  head)
{
    Node temp = head;

while (temp.next != null) {
    Node t = temp.prev;
    temp.prev = temp.next;
    temp.next = t;
    temp = temp.prev;
}

Node t = temp.prev;
temp.prev = temp.next;
temp.next = t;

head = temp;

return head;

}
