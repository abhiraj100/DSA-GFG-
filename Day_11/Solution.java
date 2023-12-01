public static Node reverseDLL(Node  head)
{
    //Your code here
    Node temp = head;

while (temp.next != null) {
    Node t = temp.prev;
    temp.prev = temp.next;
    temp.next = t;
    temp = temp.prev;
}

// Handling the last node separately
Node t = temp.prev;
temp.prev = temp.next;
temp.next = t;

// Update the head to the new starting point
head = temp;

return head;

}
