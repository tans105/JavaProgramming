package competitiveProgramming.geekforgeeks.mustdoquestions.linkedlist;

/*
https://www.geeksforgeeks.org/flattening-a-linked-list/

Flattening a Linked List

Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted. For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
 */
public class FlattenLinkedList {
    public static void main(String[] args) {
        Node head = null;

        /*
       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
         */

        int[] arr1 = {30, 8, 7, 5};
        int[] arr2 = {20, 10};
        int[] arr3 = {50, 22, 19};
        int[] arr4 = {45, 40, 35, 28};

        head = createVerticalList(head, arr1);
        head.next = createVerticalList(head.next, arr2);
        head.next.next = createVerticalList(head.next.next, arr3);
        head.next.next.next = createVerticalList(head.next.next.next, arr4);

        // flatten and sort the list
        Node node = head;
        while (head.next != null) {
            node = merge(node, head.next); //calling merge recursively for merged linkedlist in the preiovious iteration and the next linkedlist
            head = head.next;
        }

        printList(node);
    }

    /**
     *
     * @param n1 linkedlist one
     * @param n2 linkedlist two
     * @return Merge the two linkedlist and give reference to the head.
     */
    private static Node merge(Node n1, Node n2) {
        Node n3 = null;

        if (n1.data < n2.data) {
            n3 = n1;
            n1 = n1.down;
        } else {
            n3 = n2;
            n2 = n2.down;
        }

        Node ref = n3;

        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                n3.down = n1;
                n1 = n1.down;
            } else {
                n3.down = n2;
                n2 = n2.down;
            }
            n3 = n3.down;
        }

        if (n1 != null) {
            while (n1 != null) {
                n3.down = n1;
                n1 = n1.down;
            }
        }

        if (n2 != null) {
            while (n2 != null) {
                n3.down = n2;
                n2 = n2.down;
                n3 = n3.down;
            }
        }

        return ref;
    }

    public static Node createVerticalList(Node head, int[] arr) {
        for (int key : arr) {
            head = push(head, key);
        }
        return head;
    }

    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.down;
        }

        System.out.println("null");
    }

    public static Node push(Node head, int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = null;
        newNode.down = head;

        return newNode;
    }


    static class Node {
        int data;
        Node next;
        Node down;

        @Override
        public String toString() {
            return String.valueOf(data);

        }
    }

    ;
}
