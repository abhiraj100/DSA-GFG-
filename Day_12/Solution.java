class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
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